package Metiator;

public class Main {
    public static void main(String[] args) {
        TravelSystem travelSystem = new TravelSystem();

        TravelCompanySubsystem travelCompanies = new TravelCompanySubsystem(travelSystem);
        HotelsSubsystem hotels = new HotelsSubsystem(travelSystem);
        RestaurantsSubsystem restaurants = new RestaurantsSubsystem(travelSystem);
        AirportSubsystem airports = new AirportSubsystem(travelSystem);
        TourismAttractionsSubsystem attractions = new TourismAttractionsSubsystem(travelSystem);

        travelSystem.setTravelCompanies(travelCompanies);
        travelSystem.setHotels(hotels);
        travelSystem.setRestaurants(restaurants);
        travelSystem.setAirports(airports);
        travelSystem.setAttractions(attractions);

        travelCompanies.sendMessage("Customer information from Travel Company.");
        hotels.sendMessage("Customer information from Hotels.");
        restaurants.sendMessage("Customer information from Restaurants.");
        airports.sendMessage("Customer information from Airports.");
        attractions.sendMessage("Customer information from Tourism Attractions.");
    }
}
