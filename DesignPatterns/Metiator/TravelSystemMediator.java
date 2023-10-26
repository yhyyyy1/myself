package Metiator;

import java.util.ArrayList;
import java.util.List;

// 中介者接口
interface TravelSystemMediator {
    void setTravelCompanies(TravelCompanySubsystem travelCompanies);

    void setHotels(HotelsSubsystem hotels);

    void setRestaurants(RestaurantsSubsystem restaurants);

    void setAirports(AirportSubsystem airports);

    void setAttractions(TourismAttractionsSubsystem attractions);

    void sendInformation(String message, Subsystem sender);
}

// 子系统接口
interface Subsystem {
    void sendMessage(String message);

    void receiveMessage(String message);
}

// 具体子系统：旅行社子系统
class TravelCompanySubsystem implements Subsystem {
    private TravelSystemMediator mediator;

    public TravelCompanySubsystem(TravelSystemMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendInformation(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Travel Company received message: " + message);
    }
}

// 具体子系统：宾馆子系统
class HotelsSubsystem implements Subsystem {
    private TravelSystemMediator mediator;

    public HotelsSubsystem(TravelSystemMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendInformation(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Hotels received message: " + message);
    }
}

// 具体子系统：餐厅子系统
class RestaurantsSubsystem implements Subsystem {
    private TravelSystemMediator mediator;

    public RestaurantsSubsystem(TravelSystemMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendInformation(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Restaurants received message: " + message);
    }
}

// 具体子系统：机场子系统
class AirportSubsystem implements Subsystem {
    private TravelSystemMediator mediator;

    public AirportSubsystem(TravelSystemMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendInformation(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Airport received message: " + message);
    }
}

// 具体子系统：旅游景点子系统
class TourismAttractionsSubsystem implements Subsystem {
    private TravelSystemMediator mediator;

    public TourismAttractionsSubsystem(TravelSystemMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendInformation(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Tourism Attractions received message: " + message);
    }
}

// 具体中介者
class TravelSystem implements TravelSystemMediator {
    private TravelCompanySubsystem travelCompanies;
    private HotelsSubsystem hotels;
    private RestaurantsSubsystem restaurants;
    private AirportSubsystem airports;
    private TourismAttractionsSubsystem attractions;

    public void setTravelCompanies(TravelCompanySubsystem travelCompanies) {
        this.travelCompanies = travelCompanies;
    }

    public void setHotels(HotelsSubsystem hotels) {
        this.hotels = hotels;
    }

    public void setRestaurants(RestaurantsSubsystem restaurants) {
        this.restaurants = restaurants;
    }

    public void setAirports(AirportSubsystem airports) {
        this.airports = airports;
    }

    public void setAttractions(TourismAttractionsSubsystem attractions) {
        this.attractions = attractions;
    }

    @Override
    public void sendInformation(String message, Subsystem sender) {
        if (sender instanceof TravelCompanySubsystem) {
            hotels.receiveMessage(message);
            restaurants.receiveMessage(message);
            airports.receiveMessage(message);
            attractions.receiveMessage(message);
        } else if (sender instanceof HotelsSubsystem) {
            travelCompanies.receiveMessage(message);
            restaurants.receiveMessage(message);
            airports.receiveMessage(message);
            attractions.receiveMessage(message);
        } else if (sender instanceof RestaurantsSubsystem) {
            travelCompanies.receiveMessage(message);
            hotels.receiveMessage(message);
            airports.receiveMessage(message);
            attractions.receiveMessage(message);
        } else if (sender instanceof AirportSubsystem) {
            travelCompanies.receiveMessage(message);
            hotels.receiveMessage(message);
            restaurants.receiveMessage(message);
            attractions.receiveMessage(message);
        } else if (sender instanceof TourismAttractionsSubsystem) {
            travelCompanies.receiveMessage(message);
            hotels.receiveMessage(message);
            restaurants.receiveMessage(message);
            airports.receiveMessage(message);
        }
    }
}

