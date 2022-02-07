package com.example.mowater.ui.fragment.CarShowRoom.CarShowRoomMoreDetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.CarShowRoomMoreDetailsAdapter;
import com.example.mowater.data.models.CarShowRoomDetails.MainVehicle;
import com.example.mowater.ui.activities.Vehicle.VehicleActivity;


public class CarShowRoomMoreDetailsFragment extends Fragment implements CarShowRoomMoreDetailsContract.View {
    int carShowRoomId;
    int vehicleId;
    com.example.mowater.data.models.CarShowRoomDetails.Data carShowRoomObjcet;
    CarShowRoomsMoreDetailsViewModel viewModel;
    NavController navController;
    // RecyclerView && Adapter
    CarShowRoomMoreDetailsAdapter adapter;
    RecyclerView rvVehicle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_show_room_more_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        carShowRoomId = CarShowRoomMoreDetailsFragmentArgs.fromBundle(getArguments()).getCarShowRoomId();
        carShowRoomObjcet = CarShowRoomMoreDetailsFragmentArgs.fromBundle(getArguments()).getCarShowRoomObject();
        viewModel = ViewModelProviders.of(getActivity()).get(CarShowRoomsMoreDetailsViewModel.class);
        viewModel.setContract(this);
        viewModel.start();

    }

    @Override
    public void initUi() {
        rvVehicle = getView().findViewById(R.id.rv_car_show_model_vehicles);
    }

    @Override
    public void initrvCalModel() {
        rvVehicle.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CarShowRoomMoreDetailsAdapter(carShowRoomObjcet.getVehicles());
        rvVehicle.setAdapter(adapter);
        adapter.onItemClickListner(new CarShowRoomMoreDetailsAdapter.OnItemClickListner() {
            @Override
            public void onClickListner(int position) {

                vehicleId = carShowRoomObjcet.getVehicles().get(position).getId();
                Intent intent=new Intent(getContext(), VehicleActivity.class);
                intent.putExtra("flag","show_room");
                intent.putExtra("vehicle_id", vehicleId);
                intent.putExtra("car_show_room_id", carShowRoomId);
                startActivity(intent);

            }
        });
    }

    @Override
    public void replaceFragment(MainVehicle carModel) {

    }
}