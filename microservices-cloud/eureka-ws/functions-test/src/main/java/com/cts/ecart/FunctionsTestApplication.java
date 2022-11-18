package com.cts.ecart;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class FunctionsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionsTestApplication.class, args);
	}
	
	private List<TollStation> tollStations;

	
	public FunctionsTestApplication() {
		tollStations=new ArrayList<>();
		tollStations.add(new TollStation("100A", 112.5f, 2));
		tollStations.add(new TollStation("111B", 124f, 4));
		tollStations.add(new TollStation("112C", 126f, 2));
		
	}
	
	@Bean
	public Function<String, TollStation> retriveStation() {
		return value->{
			System.out.println("received request for station "+value);
			return tollStations.stream().filter(toll->value.equals(toll.getStationId())).findAny().orElse(null);
		};
	}
	
	@Bean
	public Consumer<TollRecord> processTollRecord() {
		return value->{
			System.out.println("received toll for car with license plate - " + value. getLicensePlate());
		};
		
	}
	
	@Bean
	public Function<TollRecord, Mono<Void>> processTollRecordReactive() {
		
		return value->{
			System.out.println("received reactive toll for car with license plate - " + value. getLicensePlate());
			return Mono.empty();
			
		};
		
	}
	
	@Bean
	public Consumer<Flux<TollRecord>> processListofTollRecordsReactive() {
		return value->{
		  value.subscribe(toll->System.out.println(toll.getLicensePlate()));
		};
	}
	
	@Bean
	public Supplier<Flux<TollStation>> getTollStations() {
		return()->Flux.fromIterable(tollStations);
	}
	
	

}
