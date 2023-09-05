package com.example.projetolistgame;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome;
    ImageView imageViewPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        associaJavaXml();
        Retrofit retrofitInstance = RetrofitApi.getInstance();
        GameAPIService service = retrofitInstance.create(GameAPIService.class);
//        preencheMemes();

        editTextNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                Call<Results> call = service.getGameByName(editable.toString());
                call.enqueue(new Callback<Results>() {
                    @Override
                    public void onResponse(Call<Results> call, Response<Results> response) {
                        Results results = response.body();
                        Results.Result firstResult = results.results.get(0);
                        loadActivityFilds(firstResult);

                    }

                    @Override
                    public void onFailure(Call<Results> call, Throwable t) {
                    }
                });
            }
        });
    }

    private void loadActivityFilds(Results.Result firstResult){
        Picasso.get().load(firstResult.background_image)
                .into(imageViewPoster);
//        editTextNomeRetornado.setText(firstResult.name);
//        editTextAvaliacao.setText(firstResult.rating);
//        editTextAno.setText(firstResult.released);
    }
    private void associaJavaXml() {
        editTextNome = findViewById(R.id.editTextNome);
        imageViewPoster = findViewById(R.id.ImageViewPoster);
    }
//    private void preencheMemes() {
//        DtoGame dtoMeme1 = new DtoGame();
//        DtoGame1.setDescricao("Uns sofrem por amor, eu sofro pra \n ganhar panturrilha");
//        dtoMeme1.setAnoCriacao("2023");
//        dtoMeme1.setImagemMeme(R.drawable.meme1);
//
//        DtoMeme dtoMeme2 = new DtoMeme();
//        dtoMeme2.setDescricao("O aluno mais aplicado da turma");
//        dtoMeme2.setAnoCriacao("2023");
//        dtoMeme2.setImagemMeme(R.drawable.meme2);
//
//        DtoMeme dtoMeme3 = new DtoMeme();
//        dtoMeme3.setDescricao("Eu menti, não vai ter picanha, só whey ");
//        dtoMeme3.setAnoCriacao("2022");
//        dtoMeme3.setImagemMeme(R.drawable.meme3);
//
//        ArrayList<DtoMeme> memeArrayList = new ArrayList<>();
//        memeArrayList.add(dtoMeme1);
//        memeArrayList.add(dtoMeme2);
//        memeArrayList.add(dtoMeme3);
//
//        CustomListAdapter adapter =
//                new CustomListAdapter(MainActivity.this, memeArrayList);
//        ListView listView = findViewById(R.id.listViewMeme);
//        listView.setAdapter(adapter);
//    }
}