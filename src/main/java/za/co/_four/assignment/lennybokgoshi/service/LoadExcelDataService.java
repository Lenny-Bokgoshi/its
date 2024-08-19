package za.co._four.assignment.lennybokgoshi.service;

import jakarta.annotation.PostConstruct;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import za.co._four.assignment.lennybokgoshi.domain.Planet;
import za.co._four.assignment.lennybokgoshi.domain.Route;
import za.co._four.assignment.lennybokgoshi.domain.Traffic;
import za.co._four.assignment.lennybokgoshi.respository.PlanetRepository;
import za.co._four.assignment.lennybokgoshi.respository.RouteRepository;
import za.co._four.assignment.lennybokgoshi.respository.TrafficRepository;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 * This class serves to load the excel sheet data into the database
 * */
@Service
public class LoadExcelDataService {

    private final ResourceLoader resourceLoader;
    private final PlanetRepository planetRepository;
    private final RouteRepository routeRepository;
    private final TrafficRepository trafficRepository;

    public LoadExcelDataService(ResourceLoader resourceLoader, PlanetRepository planetRepository, RouteRepository routeRepository, TrafficRepository trafficRepository) {
        this.resourceLoader = resourceLoader;
        this.planetRepository = planetRepository;
        this.routeRepository = routeRepository;
        this.trafficRepository = trafficRepository;
    }

    // TODO: Fix Derby Database configuration and access imported data
//    @PostConstruct
    public void loadData() throws IOException {
        // Correctly reference the Excel file
        String path = "/data/27four-IM.xlsx";

        // Load the Excel file using ResourceLoader
        Resource resource = new ClassPathResource(path);
        InputStream file = resource.getInputStream();

        Workbook workbook = new XSSFWorkbook(file);


        Sheet planetData = workbook.getSheetAt(0);
//        this.loadPlanets(planetData);

        Sheet routeData = workbook.getSheetAt(1);
//        this.loadRoutes(routeData);

        Sheet trafficData = workbook.getSheetAt(2);
//        this.loadTraffic(trafficData);

        workbook.close();
        file.close();
    }

    public void loadPlanets(Sheet planetSheet) {
        for (int i = 1; i < planetSheet.getPhysicalNumberOfRows(); i++) {
            Row planetRow = planetSheet.getRow(i);
            Planet newPlanet = new Planet();
            newPlanet.setNode(planetRow.getCell(0).getStringCellValue());
            newPlanet.setName(planetRow.getCell(1).getStringCellValue());

            planetRepository.save(newPlanet);
        }
    }

    public void loadRoutes(Sheet routeSheet) {
        for (int i = 1; i < routeSheet.getPhysicalNumberOfRows(); i++) {
            Row routeRow = routeSheet.getRow(i);
            Route newRoute = new Route();
            newRoute.setOrigin(routeRow.getCell(1).getStringCellValue());
            newRoute.setDestination(routeRow.getCell(2).getStringCellValue());
            newRoute.setDistance(new BigDecimal(routeRow.getCell(3).getNumericCellValue()));

            routeRepository.save(newRoute);
        }
    }

    public void loadTraffic(Sheet trafficSheet) {
        for (int i = 1; i < trafficSheet.getPhysicalNumberOfRows(); i++) {
            Row trafficRow = trafficSheet.getRow(i);
            Traffic newTraffic = new Traffic();
            newTraffic.setOrigin(trafficRow.getCell(1).getStringCellValue());
            newTraffic.setDestination(trafficRow.getCell(2).getStringCellValue());
            newTraffic.setDelay(new BigDecimal(trafficRow.getCell(3).getNumericCellValue()));

            trafficRepository.save(newTraffic);
        }
    }


}
