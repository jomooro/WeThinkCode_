import 'package:flutter/material.dart';

class SettingsView extends StatefulWidget {
  const SettingsView({super.key});

  @override
  State<SettingsView> createState() => _SettingsViewState();
}

class _SettingsViewState extends State<SettingsView> {
  bool _showPetrolPrice = true;

  bool _showDieselPrice = true;
  bool _notifyPriceChanges = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          icon: const Icon(Icons.close),
          onPressed: () {
            Navigator.of(context).pop();
          },
        ),
        title: const Text('Settings'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        children: <Widget>[
          const SizedBox(
            height: 16.0,
          ),
          _buildToggleRow(context, 'Show Petrol Price', _showPetrolPrice,
              _updateShowPetrol),
          _buildToggleRow(context, 'Show Diesel Price', _showDieselPrice, _updateDieselPrice),
          _buildToggleRow(context, 'Notify Price Changes', _notifyPriceChanges, _updatePriceChanges),
        ],
      ),
    );
  }

  void _updateShowPetrol(bool value) {
    setState(() {
      _showPetrolPrice = value;
    });
  }

  void _updateDieselPrice(bool value) {
    setState(() {
      _showDieselPrice = value;
    });
  }

  void _updatePriceChanges(bool value) {
    setState(() {
      _notifyPriceChanges = value;
    });
  }

  Widget _buildToggleRow(BuildContext context, String label, bool initialValue,
      void Function(bool value) updateFunction) {
    return Row(
      children: <Widget>[
        Text(label),
        const Spacer(),
        Switch(
          value: initialValue,
          onChanged: updateFunction,
        ),
      ],
    );
  }
}
