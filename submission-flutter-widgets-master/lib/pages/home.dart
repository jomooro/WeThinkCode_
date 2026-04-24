import 'package:flutter/material.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _petrolPricePerLitre = 24;
  int _dieselPricePerLitre = 28;

  void _incrementPetrolPrice() {
    setState(() {
      _petrolPricePerLitre++;
    });
  }

  void _incrementDieselPrice() {
    setState(() {
      _dieselPricePerLitre++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          icon: const Icon(Icons.settings),
          onPressed: () {},
        ),
        title: Text(widget.title),
        actions: [
          IconButton(
            icon: const Icon(Icons.add),
            onPressed: _incrementDieselPrice,
          )
        ],
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Container(
              decoration: BoxDecoration(
                border: Border.all(color: Colors.green, width: 2.0),
              ),
              padding: EdgeInsets.all(10),
              child: Column(
                children: [
                  const Text(
                    'Current Petrol Price:',
                  ),
                  Text(
                    'R$_petrolPricePerLitre per litre.',
                    style: Theme.of(context).textTheme.headline4,
                  ),
                ],
              ),
            ),
            const SizedBox(height: 30),
            Container(
              decoration: BoxDecoration(
                border: Border.all(color: Colors.orange, width: 2.0),
              ),
              padding: EdgeInsets.all(10),
              child: Column(
                children: [
                  const Text(
                    'Current Diesel Price:',
                  ),
                  Text(
                    'R$_dieselPricePerLitre per litre.',
                    style: Theme.of(context).textTheme.headline4,
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementPetrolPrice,
        tooltip: 'Increment Fuel Price',
        child: const Icon(Icons.add),
      ),
    );
  }
}
