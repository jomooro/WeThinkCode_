import 'package:flutter/material.dart';
import 'package:themed_app/home.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Themed App',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      //TODO darkTheme: AppTheme.customDarkTheme(),
      home: const MyHomePage(title: 'Themed Home'),
    );
  }
}


