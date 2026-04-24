enum FuelType {
  petrol, diesel
}

/// Use this class to represent pricing events that must be stored to Firestore
class PriceEvent {
  final DateTime timestamp;
  final FuelType fuelType;
  final int price;

  PriceEvent({required this.timestamp, required this.fuelType, required this.price});

  PriceEvent.basic(FuelType fuelType, int price) : this(
    timestamp: DateTime.now(),
    fuelType: fuelType,
    price: price
  );

  PriceEvent.fromJson(Map<String, Object?> jsonMap ) : this(
    timestamp: DateTime.parse(jsonMap['timestamp'] as String),
    price: jsonMap['price'] as int,
    fuelType: (jsonMap['fuelType'] as String) == 'diesel' ? FuelType.diesel : FuelType.petrol
  );

  Map<String, Object?> toJson() {
    return {
      'timestamp': timestamp.toIso8601String(),
      'price': price,
      'fuelType': fuelType.name
    };
  }

  @override
  String toString() {
    return 'PriceEvent{timestamp: $timestamp, fuelType: $fuelType, price: $price}';
  }
}