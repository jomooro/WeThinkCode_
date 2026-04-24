
import 'package:flutter/foundation.dart';
import 'package:fuel_app/model/price_event.dart';
import 'package:fuel_app/repository/fuel_repository.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
// import 'package:firebase_auth/firebase_auth.dart';
// import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
// import 'package:fuel_app/firebase_options.dart';
// import 'package:fuel_app/main.dart' as home_screen;


///Contains the relevant data for our views regarding fuel prices
class FuelPriceModel extends  ChangeNotifier {
  //TODO: use this repository to update prices to firestore, and load priceEvents from firestore
  final FuelRepository fuelRepository = FuelRepository();
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  int _petrolPricePerLitre = 21;
  int _dieselPricePerLitre = 22;

  bool _showPetrolPrice = true;
  bool _showDieselPrice = true;

  PriceEvent priceEvent = PriceEvent.basic(FuelType.petrol, 50);

  Future<void> _updateFirestore() async {
  PriceEvent priceChangeEvent = PriceEvent(
    timestamp: DateTime.now(),
    fuelType: FuelType.petrol, 
    price: currentPetrolPrice,  
  );

  Map<String, Object?> json = priceChangeEvent.toJson();

  await _firestore.collection('events').add(json);
} 

  void incrementPetrolPrice() {
    _petrolPricePerLitre++;
    notifyListeners();
    _updateFirestore();
  }

  void incrementDieselPrice() {
    _dieselPricePerLitre++;
    notifyListeners();
    _updateFirestore();  
  }

  void updatePetrolPrice(int newPrice){
    _petrolPricePerLitre = newPrice;
    notifyListeners();
  }

  void updateDieselPrice(int newPrice){
    _dieselPricePerLitre = newPrice;
    notifyListeners();
  }

  int get currentPetrolPrice => _petrolPricePerLitre;

  int get currentDieselPrice => _dieselPricePerLitre;

  void updateShowPetrolPrice(bool show) {
    _showPetrolPrice = show;
    notifyListeners();
  }

  bool get showPetrolPrice => _showPetrolPrice;

  void updateShowDieselPrice(bool show) {
    _showDieselPrice = show;
    notifyListeners();
  }

  bool get showDieselPrice => _showDieselPrice;

}