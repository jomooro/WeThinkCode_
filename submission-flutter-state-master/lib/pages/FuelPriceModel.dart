import 'package:flutter/material.dart';

class FuelPriceModel extends  ChangeNotifier {
  int _petrolPricePerLitre = 21;
  int _dieselPricePerLitre = 22;
  int get currentPetrolPrice => _petrolPricePerLitre;
  int get currentDieselPrice => _dieselPricePerLitre;
  
  bool get showDieselPrice => _showDieselPrice;
  bool get showPetrolPrice => _showPetrolPrice;
  bool _showPetrolPrice = true;
  bool _showDieselPrice = true;

  void incrementPetrolPrice() {
    _petrolPricePerLitre++;
    notifyListeners();
  }

  void incrementDieselPrice() {
    _dieselPricePerLitre++;
    notifyListeners();
  }

  void updatePetrolPrice(int newPrice){
    _petrolPricePerLitre = newPrice;
    notifyListeners();
  }

  void updateDieselPrice(int newPrice){
    _dieselPricePerLitre = newPrice;
    notifyListeners();
  }

  void updateShowPetrolPrice(bool show) {
    _showPetrolPrice = show;
    notifyListeners();
  }

  void updateShowDieselPrice(bool show) {
    _showDieselPrice = show;
    notifyListeners();
  }
}