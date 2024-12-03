package com.example.projecgestionevenements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment; // Add this import for Fragment
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FirebaseFirestore firestore;
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<Event> eventList;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirebaseApp.initializeApp(getContext());  // Initialize Firebase
        firestore = FirebaseFirestore.getInstance();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        eventList = new ArrayList<>();
        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        fetchEvents();
    }

    private void fetchEvents() {
        firestore.collection("events")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        eventList.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Event event = document.toObject(Event.class);
                            eventList.add(event);
                        }
                        eventAdapter.notifyDataSetChanged();
                    } else {
                        Log.e("Firestore", "Error getting documents: ", task.getException());
                    }
                });
    }
}
