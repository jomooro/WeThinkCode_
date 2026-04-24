import 'package:fuel_app/model/price_event.dart';
import 'package:logger/logger.dart';

/// Manages storing and retrieval of PriceEvents from Firebase
/// The idea is that you use a class like this in FuelPriceModel, instead of using FirebaseFirestore SDK directly from views
class FuelRepository {
  var logger = Logger();

  //TODO: look at how to use a CollectionReference for conversting from Object to JSON and back
  // final priceEventsRef = FirebaseFirestore.instance
  //     .collection('events')
  //     .withConverter<PriceEvent>(
  //   fromFirestore: (snapshot, _) => PriceEvent.fromJson(snapshot.data()!),
  //   toFirestore: (event, _) => event.toJson(),
  // );

  /// Adds a new event to the collection
  Future<void> addPriceEvent(PriceEvent event) async {
    logger.i('Adding new PriceEvent ${event.toJson()}');
    //TODO: write to firestore using FirebaseFirestore or a collectionReference
  }

  /// Retrieves most recent 100 events
  Future<List<PriceEvent>> getRecentPriceEvents() async {
    logger.i('Retrieving recent price events');
    //TODO: retrieve from firestore using FirebaseFirestore or a collectionReference
    return Future.value([]);
  }

  /// Retrieves most recent 100 events
  Future<List<PriceEvent>> getRecentPriceEventsForFuelType(FuelType fuelType) async {
    logger.i('Retrieving recent price events for ${fuelType.name}');
    //TODO: retrieve from firestore using FirebaseFirestore or a collectionReference
    return Future.value([]);
  }

  /// Retrieve most recent price event of specified fueltype
  Future<PriceEvent> getMostRecentPrice(FuelType fuelType) async {
    List<PriceEvent> events = await getRecentPriceEventsForFuelType(fuelType);
    if (events.isNotEmpty) {
      return events.first;
    } else {
      return PriceEvent(timestamp: DateTime.now(), fuelType: fuelType, price: 24);
    }
  }
}
