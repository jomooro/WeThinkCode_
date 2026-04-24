// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility in the flutter_test package. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct

import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:funky_app/views/JumpingJackView.dart';
import 'package:funky_app/views/SpinningView.dart';
import 'package:funky_app/views/home.dart';


void main() {
  testWidgets('FunkyHomeView Animation test', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MaterialApp(
      home: FunkyHomeView(title: 'Test Funky Home'),
    ));

    final animatedContainer = find.byType(AnimatedContainer);

    // Ensure the initial size of the animated container
    expect(tester.getSize(animatedContainer), const Size(100.0, 100.0));

    // Trigger the zoom animation
    await tester.tap(find.byType(IconButton));
    await tester.pumpAndSettle();

    // Ensure the final size of the animated container
    expect(tester.getSize(animatedContainer), const Size(200.0, 200.0));
  });

  testWidgets('FunkyHomeView Button press test', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MaterialApp(
      home: FunkyHomeView(title: 'Test Funky Home'),
    ));

    final animatedContainer = find.byType(AnimatedContainer);

    // Ensure the initial size of the animated container
    expect(tester.getSize(animatedContainer), const Size(100.0, 100.0));

    // Trigger the zoom animation by pressing the button
    await tester.tap(find.byType(IconButton));
    await tester.pumpAndSettle();

    // Ensure the final size of the animated container
    expect(tester.getSize(animatedContainer), const Size(200.0, 200.0));
  });

  testWidgets('SpinningView Initial State', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MaterialApp(
      home: SpinningView(title: 'Test SpinningView'),
    ));

    // Verify that the SpinningView is initially not spinning.
    expect(find.text('Stop'), findsNothing);
    expect(find.text('Spin'), findsOneWidget);
  });

  testWidgets('SpinningView Start Spinning', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MaterialApp(
      home: SpinningView(title: 'Test SpinningView'),
    ));

    // Tap the Spin button.
    await tester.tap(find.text('Spin'));
    await tester.pump();

    // Verify that the SpinningView is now spinning.
    expect(find.text('Stop'), findsOneWidget);
    expect(find.text('Spin'), findsNothing);
  });

  testWidgets('SpinningView Stop Spinning', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MaterialApp(
      home: SpinningView(title: 'Test SpinningView'),
    ));

    // Tap the Spin button.
    await tester.tap(find.text('Spin'));
    await tester.pump();

    // Tap the Stop button.
    await tester.tap(find.text('Stop'));
    await tester.pump();

    // Verify that the SpinningView has stopped spinning.
    expect(find.text('Stop'), findsNothing);
    expect(find.text('Spin'), findsOneWidget);
  });

  testWidgets('JumpingJackView Initial State', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MaterialApp(
      home: JumpingJackView(title: 'Test JumpingJackView'),
    ));

    // Verify that the Jump button and icon are initially visible.
    expect(find.text('Jump'), findsOneWidget);
    expect(find.byIcon(Icons.directions_run), findsOneWidget);
  });

  testWidgets('JumpingJackView Jump Animation', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MaterialApp(
      home: JumpingJackView(title: 'Test JumpingJackView'),
    ));

    // Tap the Jump button.
    await tester.tap(find.text('Jump'));
    await tester.pump();

    // Verify that the JumpingJackView performs the jump animation.
    await tester.pump(const Duration(milliseconds: 1500)); // Wait for the animation to complete
    expect(find.byIcon(Icons.directions_run), findsOneWidget);
  });

  testWidgets('JumpingJackView Loop Back', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MaterialApp(
      home: JumpingJackView(title: 'Test JumpingJackView'),
    ));

    // Tap the Jump button multiple times to make Jumping Jack reach the end of the screen.
    await tester.tap(find.text('Jump'));
    await tester.pump();
    await tester.tap(find.text('Jump'));
    await tester.pump();
    await tester.tap(find.text('Jump'));
    await tester.pump();

    // Verify that Jumping Jack loops back to the start.
    expect(find.byIcon(Icons.directions_run), findsOneWidget);
  });
}
