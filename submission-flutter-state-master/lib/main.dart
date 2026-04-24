import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:fuel_app/pages/FuelPriceModel.dart';
import 'package:fuel_app/pages/home.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Fuel4U',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: ChangeNotifierProvider(
          create: (context) => FuelPriceModel(),
          child: const MyHomePage(title: 'Fuel4U'),
      )
    );
  }
}