package com.example.interactivenavigationrtumap;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.ortiz.touchview.TouchImageView;

import java.util.Collections;
import java.util.Vector;

import kotlin.BuilderInference;

/*
TODO
Zoom in to location when a room is selected
A location point/dot when a room is selected
Pop up panel for more detail of a location: building in, floor, picture
Implement search bar???

 */
public class MainMapActivity extends AppCompatActivity {

    Room registrar = new Room("Registrar", 1);
    Room library1 = new Room("Library", 3);
    Room coop = new Room("Co-Op", 1);
    Room mic = new Room("MIC", 1);
    Room cpe_faculty = new Room("CpE Faculty", 1);
    Room ece_faculty = new Room("ECE Faculty", 3);
    Room coe_center = new Room("COE Center", 3);
    Room ece_lab= new Room("ECE Lab", 1);
    Room cpe_lab = new Room("CpE Lab", 1);
    Room library2 = new Room("Library 2", 2);
    Room dormitory= new Room("Dormitory", 0);
    Room alumni_room = new Room("Alumni Room", 4);
    Room gymnasium = new Room("Gymnasium", 0);
    Room legal_office= new Room("University Legal Affairs Office", 2);
    Room psychology_lab = new Room("Psychology Lab", 6);
    Room cpe_office = new Room("Computer Engineering Office", 1);
    Room motor_parkinglot = new Room("Motor Parking Lot", 1);
    Room elevator = new Room("Elevator", 1);
    Room csa = new Room("Center for Student Affairs Scholarship & Grant Office", 1);
    Room ovp = new Room("Office of the Vice President for Academic Affairs", 1);
    Room cashier = new Room("Cashier", 1);
    Room edp = new Room("Electronic Data Processing", 1);
    Room odfs = new Room("Office of the Director Financial Services", 2);
    Room bac = new Room("BAC Office", 3);
    Room dmst = new Room("Department of Military Science & Tactics (NSTP & ROTC)", 1);
    Room lao_ubs = new Room("Legal Affairs Office of the University Board Secretary", 2);
    Room cea_dean_office = new Room("CEA Dean's Office", 2);

    Building mab = new Building("Main Academic Building",
            new Room[]{registrar, library1}, 5,(float) 0.5685061,(float) 0.6698321);
    Building promenade = new Building("Promenade", new Room[]{coop}, 5,(float) 0.3975647,(float) 0.5957413);
    Building profeta = new Building("Dr. Lyndia M. Profeta Building",
            new Room[]{mic, ovp, cashier, edp, odfs}, 5, (float) 0.5477178, (float) 0.29707468);
    Building estolas = new Building("Dr. Josefina Estolas Building",
            new Room[]{cpe_faculty, ece_faculty, coe_center, ece_lab, cpe_lab, legal_office, cpe_office, bac, lao_ubs, cea_dean_office},
            (float) 4.5,(float) 0.3921668, (float) 0.35573292);
    Building rnd = new Building("R&D Building",
            new Room[]{library2, psychology_lab, elevator}, (float) 4.5,  (float) 0.79755753, (float) 0.33884767);
    Building sngd = new Building("Sen. Neptali Gonzales Dormitory",
        new Room[]{dormitory}, 5,(float) 0.5018833, (float) 0.22385061);
    Building alumni_bldg = new Building("Alumni Building",
            new Room[]{alumni_room}, 5, (float) 0.2825684, (float) 0.46298453);
    Building gym_bldg = new Building("Gymnasium",
            new Room[]{gymnasium}, 5, (float) 0.39770386, (float) 0.70849496);
    Building gate1 = new Building("Gate 1",
            new Room[]{motor_parkinglot}, 5,(float) 0.68480724, (float) 0.82457864);
    Building old_bldg_west = new Building("Old Building (West Wing)",
            new Room[]{dmst}, 5, (float) 0.7415863, (float) 0.37968463);

    Building[] buildings = new Building[] {mab, promenade, profeta, estolas, rnd, sngd, alumni_bldg, gym_bldg, gate1, old_bldg_west};
    Vector<String> buildingNames = new Vector<String>();

    ImageView redpin;
    TouchImageView rtu_map;
    int maxZoom = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_map);

        redpin = (ImageView) findViewById(R.id.redpin);
        redpin.setVisibility(View.INVISIBLE);

        rtu_map = (TouchImageView) findViewById(R.id.rtumap);
        rtu_map.setMaxZoom(maxZoom);

        buildingNames.add("Select Building");
        for (Building building : buildings) {
            buildingNames.add(building.getName());
        }

        Spinner selectBuildingSpinner = (Spinner) findViewById(R.id.selectbuilding);
        ArrayAdapter<String> buildingAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, buildingNames);
        buildingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectBuildingSpinner.setAdapter(buildingAdapter);

        Vector<String> rooms = new Vector<String>();
        rooms.add("Select Room");
        Spinner selectRoomSpinner = (Spinner) findViewById(R.id.selectroom);
        ArrayAdapter<String> roomAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rooms);
        roomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectRoomSpinner.setAdapter(roomAdapter);

        selectBuildingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String buildingSelected = selectBuildingSpinner.getSelectedItem().toString();

                currentZoomTest();

                rooms.clear();
                rooms.add("Select Room");
                selectRoomSpinner.setAdapter(roomAdapter);
                for (Building building : buildings) {
                    if(buildingSelected.equals(building.getName())) {
                        rtu_map.setZoom(building.getScale(), building.getZoomRectCenterX(), building.getZoomRectCenterY());

                        for (Room room : building.getRooms()) {
                            rooms.add(room.getName());
                        }
                        System.out.println(building.getName() + " selected");
                        selectRoomSpinner.setEnabled(true);
                        break;
                    } else {
                        selectRoomSpinner.setEnabled(false);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void currentZoomTest() {
        System.out.println("Current zoom: " + rtu_map.getCurrentZoom());
        RectF zoomedRect = rtu_map.getZoomedRect();
        System.out.println("Zoomed rect: " + zoomedRect);
        System.out.println("Center X of zoomed rect: " + zoomedRect.centerX());
        System.out.println("Center Y of zoomed rect: " + zoomedRect.centerY());
    }
}