import 'package:flutter/material.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  double _petrolPricePerLitre = 21.0;
  double _dieselPricePerLitre = 22.0;
  List<String> priceHistory = [];

  void _incrementPetrolPrice() {
    setState(() {
      _petrolPricePerLitre += 1.0;
      addPriceChangeEvent("Petrol price", _petrolPricePerLitre, 0);
    });
  }

  void _incrementDieselPrice() {
    setState(() {
      _dieselPricePerLitre += 0.5;
      addPriceChangeEvent("Diesel price", _dieselPricePerLitre, 1);
    });
  }

  void addPriceChangeEvent(String fuelType, double newPrice, int decimalPlaces) {
    String formattedPrice = newPrice.toStringAsFixed(decimalPlaces);
    priceHistory.add("$fuelType changed to R$formattedPrice");
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
            onPressed: () {
              _incrementDieselPrice();
            },
          )
        ],
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            const SizedBox(
              height: 16.0,
            ),
            Card(
              shape: RoundedRectangleBorder(
                side: const BorderSide(
                  color: Colors.green,
                ),
                borderRadius: BorderRadius.circular(20.0),
              ),
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    const Text(
                      'Current Petrol Price:',
                    ),
                    Text(
                      'R${_petrolPricePerLitre.toStringAsFixed(1)} per litre.', // Format with 1 decimal place
                      style: Theme.of(context).textTheme.headline4,
                    ),
                  ],
                ),
              ),
            ),
            const SizedBox(
              height: 16.0,
            ),
            Card(
              shape: RoundedRectangleBorder(
                side: const BorderSide(
                  color: Colors.orangeAccent,
                ),
                borderRadius: BorderRadius.circular(20.0),
              ),
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    const Text(
                      'Current Diesel Price:',
                    ),
                    Text(
                      'R${_dieselPricePerLitre.toStringAsFixed(1)} per litre.', // Format with 1 decimal place
                      style: Theme.of(context).textTheme.headline4,
                    ),
                  ],
                ),
              ),
            ),
            const SizedBox(
              height: 32.0,
            ),
            Text(
              'Fuel Price History',
              style: Theme.of(context).textTheme.headline6,
            ),
            Column(
              children: priceHistory.map((event) {
                return ListTile(
                  title: Center(child: Text(event)),
                );
              }).toList(),
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
