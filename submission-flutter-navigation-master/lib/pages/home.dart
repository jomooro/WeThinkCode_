import 'package:flutter/material.dart';
import 'settings.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _petrolPricePerLitre = 21;
  int _dieselPricePerLitre = 22;

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
          onPressed: () {
            _openSettingsView(context);
          },
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
                    borderRadius: BorderRadius.circular(20.0)),
                child: Padding(
                    padding: const EdgeInsets.all(16.0),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        const Text(
                          'Current Petrol Price:',
                        ),
                        Text(
                          'R$_petrolPricePerLitre per litre.',
                          style: Theme.of(context).textTheme.headline4,
                        ),
                      ],
                    ))),
            const SizedBox(
              height: 16.0,
            ),
            Card(
                shape: RoundedRectangleBorder(
                    side: const BorderSide(
                      color: Colors.orangeAccent,
                    ),
                    borderRadius: BorderRadius.circular(20.0)),
                child: Padding(
                    padding: const EdgeInsets.all(16.0),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        const Text(
                          'Current Diesel Price:',
                        ),
                        Text(
                          'R$_dieselPricePerLitre per litre.',
                          style: Theme.of(context).textTheme.headline4,
                        ),
                      ],
                    ))),
            const SizedBox(
              height: 32.0,
            ),
            Text(
              'Fuel Price History',
              textAlign: TextAlign.center,
              style: Theme.of(context).textTheme.headline5,
            ),
            const SizedBox(
              height: 4.0,
            ),
            Expanded(child: _buildPriceHistoryList(context)),
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

  Widget _buildPriceHistoryList(BuildContext context) {
    return ListView.builder(
        itemCount: 20,
        padding: const EdgeInsets.symmetric(horizontal: 24.0, vertical: 16.0),
        itemBuilder: (listBuildContext, index) {
          String message = index.isEven
              ? 'Diesel price changed to ${_dieselPricePerLitre - (index / 2).ceil()}'
              : 'Petrol price changed to ${_petrolPricePerLitre - (index / 2).floor()}';
          return Padding(
              padding: const EdgeInsets.all(6.0),
              child: Text(
                message,
                textAlign: TextAlign.center,
              ));
        });
  }

  _openSettingsView(BuildContext context) {
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (context) {
          return const SettingsView(); 
        },
        fullscreenDialog: true, 
      ),
    );
  }
}
