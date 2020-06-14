package com.mydogapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.mydogapplication.DogApi.Dog;
import com.mydogapplication.DogApi.DogViewModel;



public class RandomDog extends Fragment {
DogViewModel dogViewModel;
EditText searchText;
TextView setText;
View v;
Button searchBtn;

  @Override
  public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
    v = inflater.inflate(R.layout.dog_pictures,container,false);
      searchText = v.findViewById(R.id.apiTextSearch);
    setText = v.findViewById(R.id.apiText);
    searchBtn = v.findViewById(R.id.btnSearch);

    dogViewModel = new ViewModelProvider(this).get(DogViewModel.class);
    dogViewModel.getDog().observe(getViewLifecycleOwner(), new Observer<Dog>() {
      @Override
      public void onChanged(Dog dog) {
        setText.setText(dog.toString());
      }
    });

      searchBtn.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v) {
          dogViewModel.updateDog(searchText.getText().toString(), "19222f36-d78a-44e8-aba2-aa1e551a136e");
          }
      });
    return v;
  }
}



