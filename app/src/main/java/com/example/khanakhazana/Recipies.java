package com.example.khanakhazana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class Recipies extends AppCompatActivity {


    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    TextToSpeech TtS;
    ImageView ivImg,ivAudio;
    Button btnSubmit;
    TextView tvName,tvRep,etComment,tvlink;
    String rep;
    float rating;
    RatingBar rbRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipies);

        ivImg=findViewById(R.id.ivImg);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvName=findViewById(R.id.tvName);
        tvRep=findViewById(R.id.tvRep);
        rbRating=findViewById(R.id.rbRating);
        ivAudio=findViewById(R.id.ivAudio);
        etComment=findViewById(R.id.etComment);
        tvlink=findViewById(R.id.tvlink);
        tvlink.setPaintFlags(tvlink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        mFirebaseAuth=FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference();


        Intent intent=getIntent();
        final String text=intent.getStringExtra(IndianRecipes.EXTRA_TEXT);

        TtS=new TextToSpeech(Recipies.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i==TextToSpeech.SUCCESS)
                {
                    int result=TtS.setLanguage(Locale.ENGLISH);
                    if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Log.e("TtS","Language not Supported");
                    }
                    else
                    {
                        ivAudio.setEnabled(true);
                    }
                }
                else
                {
                    Log.e("TtS","Inizialization Failed!");
                }
            }
        });

        if(text.equals("khandvi"))
        {

            tvName.setText("KHANDVI");
            ivImg.setImageResource(R.drawable.indian_khandvi);
            rep=
                    "INGREDIENTS\n" +
                    "1.Gram flour 1 1/4 cups\n" +
                    "2.Yogurt 1 cup\n" +
                    "3.Ginger 1 inch\n" +
                    "4.Green chillies 2\n" +
                    "5.Oil 4 tablespoons\n" +
                    "6.Salt to taste\n" +
                    "7.Turmeric powder 1/2 teaspoon\n" +
                    "8.Lemon juice 1 tablespoon\n" +
                    "9.Asafoetida a pinch\n" +
                    "10.Mustard seeds 1 teaspoon\n" +
                    "11.Coconut scraped 2 teaspoons\n" +
                    "12.Fresh coriander leaves chopped a few sprigs\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Sieve besan and keep in a bowl. Grind ginger and green chillies. Grease the reverse side of a few thalis or marble table top with a little oil. Make buttermilk with yogurt and half a cup of water.\n" +
                    "2.Mix the besan with ginger-green chilli paste, salt, turmeric powder, lemon juice and buttermilk, taking care that no lumps remain\n" +
                    "3.Cook this mixture, stirring continuously, in a thick bottomed pan till it becomes a smooth thick batter. It takes a little time to get ready.\n" +
                    "4.Quickly spread portions of the mixture over the greased inverted thalis or marble table top as thinly as possible while the batter is still hot.\n" +
                    "5.When cool, cut into strips two inches wide and roll them tightly. Heat two tablespoons of oil and add a pinch of asafoetida and mustard seeds\n" +
                    "6.When they splutter, pour over the pieces. Serve garnished with scraped";
            tvRep.setText(rep);

            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dtvRMihki6g"));
                    startActivity(intent);
                }
            });
        }
        else if(text.equals("gulab_jamun"))
        {
            tvName.setText("GULAB JAMUN");
            ivImg.setImageResource(R.drawable.indian_gualb);
            rep="INGREDIENTS\n" +
                    "1.Mawa (khoya) 1 1/2 cups\n" +
                    "2.Chenna 1/4 cup\n" +
                    "3.Soda bicarbonate 1/4 teaspoon\n" +
                    "4.Refined flour (maida) 3 tablespoons\n" +
                    "5.Green cardamom powder 1/4 teaspoon\n" +
                    "6.Sugar 2 cups\n" +
                    "7.Ghee to deep fry\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.In a large bowl, stir together the milk powder, flour, baking powder, and cardamom. Stir in the almonds, pistachios and golden raisins. Mix in the melted ghee, then pour in the milk, and continue to mix until well blended. Cover and let rest for 20 minutes.\n" +
                    "2.In a large skillet, stir together the sugar, water, rose water and a pinch of cardamom. Bring to a boil, and simmer for just a minute. Set aside.\n" +
                    "3.Fill a large heavy skillet halfway with oil. Heat over medium heat for at least 5 minutes. Knead the dough, and form into about 20 small balls. Reduce the heat of the oil to low, and fry the balls in one or two batches. After about 5 minutes, they will start to float, and expand to twice their original size, but the color will not change much. After the jamun float, increase the heat to medium, and turn them frequently until light golden. Remove from the oil to paper towels using a slotted spoon, and allow to cool. Drain on paper towels and allow to cool slightly.\n" +
                    "4.Place the balls into the skillet with the syrup. Simmer over medium heat for about 5 minutes, squeezing them gently to soak up the syrup. Serve immediately, or chill.";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=HVMpZNHQV9c"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }
        else if(text.equals("pav_bhaji"))
        {
            tvName.setText("PAV BHAJI");
            ivImg.setImageResource(R.drawable.indian_pavbhaji);
            rep="INGREDIENTS\n" +
                    "1. 2 Tbsp Oil\n" +
                    "2. 1 Large Onion, finely chopped\n" +
                    "3. tsp Ginger (minced)\n" +
                    "4. 1 tsp Garlic (minced)\n" +
                    "5. 2 Green chillies (slit lengthwise)\n" +
                    "6. 1 Bell pepper, finely chopped\n" +
                    "7. 3 Tomatoes, finely chopped\n" +
                    "8. 1 Cup Each of these vegetables, finely diced: green beans, carrots, cauliflower, boiled\n" +
                    "9. 1 Cup Potatoes (peeled), boiled\n" +
                    "10. 1/2 Cup Green peas, boiled\n" +
                    "11. 3 tsp Pav Bhaji Masala\n" +
                    "12. 1 tsp Red chili powder\n" +
                    "13. 1/4 tsp Turmeric powder\n" +
                    "14. To taste Salt\n" +
                    "15. 1/2 tsp Lemon juice\n" +
                    "16. 2 Buns (called pavs)\n" +
                    "\n" +
                    "METHOD\n" +
                    "\n" +
                    "1.Heat oil in a pan. Add onions, ginger, garlic, and green chillies and sauté till golden brown. Add boiled vegetables and stir.\n" +
                    "2.Stir in the pav bhaji masala, turmeric, tomatoes, capsicum and salt. Add slit green chillies and water and mix it well. Cook for 4-5 minutes.\n" +
                    "3.Mash the vegetables till they are little pulpy.\n" +
                    "4.Add lemon juice and serve with toasted buns or Pav.";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=sAnPUIvPc1I"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }
        else if(text.equals("biryani"))
        {
            tvName.setText("BIRYANI");
            ivImg.setImageResource(R.drawable.indian_biryani);
            rep="INGREDIENTS\n" +
                    "\n" +
                    "\n" +
                    "1. 1 kg - Chicken\n" +
                    "2. 1 kg - Rice\n" +
                    "3. 1 bunch - pudina\n" +
                    "4. 1 bunch - Coriander leaves\n" +
                    "5. 4 to 5 - Onions\n" +
                    "6. 3 tbsp - Ginger Garlic paste\n" +
                    "7. 1.5 tbsp - chilli powder\n" +
                    "8. 1/2 tbsp - Turmeric powder\n" +
                    "9. 3 tbsp - Chicken masala\n" +
                    "10. 2 tbsp - coriander powder\n" +
                    "11. Whole Garam Masala\n" +
                    "12. 3 to 4 - biriyani leaves\n" +
                    "13. 1 cup - Curd\n" +
                    "14. 2 - Lemon\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Clean the chicken and add chilli powder, coriander powder, ginger garlic paste, salt, turmeric powder, chicken masala and curd.\n" +
                    "2.Keep aside for about 30 minutes.\n" +
                    "3.Add enough oil and fry finely chopped onions till golden brown colour. Remove from oil.\n" +
                    "4.Now drop the marinated chicken in that oil and keep it aside.\n" +
                    "5.Take rice in another vessel, add whole garam masala, biryani leaves, salt and allow it to cook.\n" +
                    "6.When rice is half cooked, strain it.\n" +
                    "7.Cook the chicken and add pudina and coriander leaves.\n" +
                    "8.Add half the boiled rice and fried onions.\n" +
                    "9.Add remaining rice and onions layer by layer and cover the vessel with a lid (don't allow pressure to go out).\n" +
                    "10.Reduce flame and cook for 40 min.\n" +
                    "11.Finally, add lime juice mixed with turmeric powder through small holes made in the rice.\n";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=XTM0wwIGXfY"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("baozi"))
        {
            tvName.setText("BAOZI");
            ivImg.setImageResource(R.drawable.chinese_baozi);
            rep="INGREDIENTS\n" +
                    "1. 1 & 1/2 tsp active dry yeast\n" +
                    "2. 3/4 cup warm water\n" +
                    "3. 2 tbsp granulated sugar\n" +
                    "4. 2 tsp baking powder\n" +
                    "5. 12 & 1/2 oz (355 grams) bleached all-purpose flour\n" +
                    "6. 2 tbsp canola oil\n" +
                    "7. 1.5 oz dried cellophane noodles/bean thread\n" +
                    "8. 5 oz savoy cabbage, finely chopped\n" +
                    "9. 4 oz shiitake mushrooms, finely chopped\n" +
                    "10. 1 small to medium carrot, finely chopped\n" +
                    "11. 4 scallions, thinly sliced\n" +
                    "12. 1 tbsp sugar\n" +
                    "13. 1 tbsp soy sauce\n" +
                    "14. 2 tbsp oyster sauce (optional)\n" +
                    "15. 1 tbsp olive oil\n" +
                    "16. 2 tsp sesame oil\n" +
                    "17. 1/2 tsp salt, plus more to taste\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Combine yeast, warm water, and 1/4 tsp of granulated sugar in a liquid measuring cup. Stir to dissolve and let sit for 5 minutes until bubbly on top. Sift the remaining sugar, baking powder, and flour together in a large mixing bowl. Add the oil and the activated yeast mixture to the flour and stir with a spoon or spatula until a lumpy dough forms.\n" +
                    "2. Once it becomes difficult to stir, use your hands to knead the dough, adding more flour if the dough is too sticky or water if it's too dry one teaspoon at a time, until it comes away cleanly from the bowl. Turn the dough onto a clean counter and knead by hand for another 5 minutes until smooth and elastic.\n" +
                    "3.Return dough to the mixing bowl, cover with plastic wrap, and let rise for 45 minutes to 1 hour until doubled in size.\n" +
                    "4.In the meantime, making the filling. Place the cellophane noodles in a heatproof bowl and add enough boiling water to submerge the noodles completely. Drain the noodles after two minutes, they should be soft but not mushy. Once cooled, roughly cut the noodles into 1 inch segments." +
                    "";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=qvOBLYVWPYY"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("fried_rice"))
        {
            tvName.setText("FRIED RICE");
            ivImg.setImageResource(R.drawable.chinese_fired_ricw);
            rep="INGREDIENTS\n" +
                    "1.Cooked rice 3 cups\n" +
                    "2.Onions finely chopped 2 medium\n" +
                    "3.French beans chopped 12-15\n" +
                    "4.Carrot finely chopped 1 medium\n" +
                    "5.Green capsicums finely chopped 1 medium\n" +
                    "6.Cabbage chopped 1/4 medium\n" +
                    "7.Spring onion greens sliced 2 stalks\n" +
                    "8.Oil 4 tablespoons\n" +
                    "9.Garlic cloves finely chopped 3-4\n" +
                    "10.Salt to taste\n" +
                    "11.White pepper powder 1/2 teaspoon\n" +
                    "12.Light soy sauce 1 teaspoon\n" +
                    "13.White vinegar 1/2 tablespoon\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Heat oil in a non stick wok, add garlic and stir-fry for one minute.\n" +
                    "Add onions, French beans, carrot, green capsicum, cabbage and half the spring onion greens. Stir-fry for two minutes.\n" +
                    "2.Add salt, white pepper powder and soy sauce and mix thoroughly.\n" +
                    "3.Add boiled rice and adjust the seasonings.\n" +
                    "4.Stir in the vinegar and cook for one minute, stirring continuously.\n" +
                    "5.Garnish with remaining spring onion greens and serve hot.";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=bXgxzzNm0U8"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }


        else if(text.equals("spring_roll"))
        {
            tvName.setText("SPRING ROLL");
            ivImg.setImageResource(R.drawable.chinese_springroll);
            rep="INGREDIENTS\n" +
                    "1.Glass noodles 100 g\n" +
                    "2.Carrot 2 each, roughly grated\n" +
                    "3.White cabbage 200 g, finely grated\n" +
                    "4.Bean sprout 200 g\n" +
                    "5.Garlic 2 cloves, finely chopped\n" +
                    "6.Sesame oil 30 ml\n" +
                    "7.Soy sauce To taste\n" +
                    "8.Spring roll pastry 20 sheets\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.To make the spring rolls start cooking the noodles according to the directions on the package.\n" +
                    "2.Mix together the carrots, cabbage, bean sprouts, garlic and oil.\n" +
                    "3.Drain the noodles and cut them into 4 cm long pieces and add them to the mixture.\n" +
                    "4.Season with salt, ground black pepper, soy sauce and a pinch of sugar and gently beat the egg.\n" +
                    "5.Remove one spring roll sheet from the pile and place on the work surface. Spread 30 ml of filling in the middle.\n" +
                    "6.Fold over the sides and roll up.\n" +
                    "7.Fry spring rolls in hot oil for 4-5 minutes until golden brown.\n" +
                    "8.Dry on kitchen paper.\n" +
                    "9.If desired serve the spring rolls with soy sauce.";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=DIjrTDDQOnM"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("turnip_cake"))
        {
            tvName.setText("TURNIP CAKE");
            ivImg.setImageResource(R.drawable.chinese_turnipcake);
            rep="INGREDIENTS\n" +
                    "1. 1 Chinese turnip/daikon radish (about 20 oz.), grated\n" +
                    "2. 1 cup water\n" +
                    "3. Oyster sauce for dipping (optional)\n" +
                    "4. white pepper, to taste\n" +
                    "5. ½ teaspoon sugar\n" +
                    "6. ½ teaspoon salt\n" +
                    "7. 1 tablespoon cornstarch\n" +
                    "8. 1 scallion, chopped\n" +
                    "9. 1 cup rice flour\n" +
                    "10.3-5 dried Chinese black mushrooms, washed, soaked, and chopped\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Add grated turnip and 1 cup water to a wok or large pan and bring to a simmer. Simmer for about 10 minutes, stirring occasionally so the turnip does not brown. The turnip will produce liquid, some of which will evaporate. You will have ¾ to 1 cup liquid left in the pan with the radish but don't worry about measuring it. Pour everything (including the liquid) into a large mixing bowl to cool.\n" +
                    "2.Heat your pan over medium heat and add a couple tablespoons oil. Add the shrimp, mushrooms, and sausage and cook for about 5 minutes. Stir in the chopped scallion and remove from the heat to cool.\n" +
                    "3.Add rice flour, cornstarch, salt, sugar, and white pepper to the mixing bowl with the radish and cooking liquid. Mix well until the dry ingredients are well-incorporated. Add in the cooked shrimp, mushrooms and sausage, and be sure to scrape the oil from the pan into the batter. Mix well and let sit for about 15 minutes.\n" +
                    "4.Give the batter a final stir and pour it into a well-oiled loaf pan. Place the pan into a steamer with plenty of water and steam over medium-high heat for 50 minutes.\n" +
                    "5.Remove the pan from the steamer and let your turnip cake set for about 30 minutes. Once cooled, loosen the sides with a spatula and turn it out onto a cutting board." +
                    "";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=c8JfP38e97s"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("sushi"))
        {
            tvName.setText("SUSHI");
            ivImg.setImageResource(R.drawable.sushi);
            rep="INGREDIENTS\n" +
                    "1. 5 sheets nori\n" +
                    "2. 2 cups sushi rice, recipe follows\n" +
                    "3. 2 ounces sushi-grade tuna, cut into1/4 by 1/2 by 3-inch strips\n" +
                    "4. 2 ounces sushi-grade salmon, cut into1/4 by 1/2 by 3-inch strips\n" +
                    "5. 1 hot house cucumber, julienne\n" +
                    "6. 1 carrot, peeled and julienne\n" +
                    "7. 1/2 avocado, thinly sliced\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Place a nori sheet lengthwise on a bamboo rolling mat, shiny-side down.\n" +
                    "2. Position the sheet about 1-inch from the edge of the mat closest to you and leave some of the bamboo mat exposed on either side of the nori sheet. Wet your hands in cool water and take a handful of sushi rice. Place the rice in the center of the nori and use your fingers to spread the rice evenly over the nori. Be sure to leave a 3/4-inch strip of nori uncovered on the far side.\n" +
                    "3. Place tuna strips and some julienne vegetable, cucumber or avocado along the center of the rice. Be careful not to overfill the nori. Place your fingertips over the fillings to hold them in place.\n" +
                    "4. Then, use your thumbs to lift up the edge of the bamboo rolling mat closest to you. Begin rolling the mat away from you, while applying pressure to the fillings to keep the roll firm.\n" +
                    "5. Roll the mat over slowly until it covers the rice and the near and far sides of rice join, still leaving the 3/4-inch strip of nori, rice-free, exposed. While holding the bamboo mat in position, apply pressure to the roll with your fingers to make the roll firm. Slice the roll in half, then cut both rolls twice to make 6 equal sized pieces.\n" +
                    "6. Repeat this process with the salmon and various fillings, nori and rice.\n" +
                    "\n" ;
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=CgSiJeltN0U"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("onigiri"))
        {
            tvName.setText("ONIGIRI");
            ivImg.setImageResource(R.drawable.onigiri);
            rep="INGREDIENTS\n" +
                    "1. 1/2 pound salmon fillet\n" +
                    "2. 4 cups uncooked, short-grain rice\n" +
                    "3. 5 3/4 cups water\n" +
                    "4. 2 sheets dried nori seaweed, or pre-toasted nori sheets\n" +
                    "5. 2 large pickled plums, pits removed and coarsely chopped\n" +
                    "6. 1/4 cup dried bonito flakes\n" +
                    "7. 1 1/2 teaspoons dark soy sauce\n" +
                    "8. 2 tablespoons black sesame seeds, toasted\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Sprinkle the salmon fillet with salt and let stand for 2 hours.\n" +
                    "2.Meanwhile, wash the rice thoroughly in cold water 30 to 60 minutes before cooking and let drain in colander. Place rice and water in a heavy, tightly covered saucepan over medium-high heat. When water just begins to boil, turn the heat to high and let it come to a vigorous boil. Reduce the heat to low and cook until all the liquid is absorbed by the rice, about 12 to 13 minutes.\n" +
                    "3. Turn off the heat and let the rice stand, covered, for 10 to 15 minutes. Using a flat wooden spoon or rice paddle, fluff the rice with a cutting motion. Stretch a towel under the lid and cover tightly to keep warm until ready to use.\n" +
                    "4.Toast the nori sheets over a high gas flame, and cut crosswise into 1-inch wide strips, or use pre-toasted nori.\n" +
                    "5.Mix the bonito flakes with the soy sauce. Rinse the salt off the salmon, pat dry, and grill for 3 to 5 minutes. Use a fork to break the salmon into small pieces.\n" +
                    "6.Wet your hands with salted water to keep the rice from sticking to your hands. Cup one hand and place a handful of rice, about 1/2 cup, in your hand. Make an indentation in the rice and tuck in one of the fillings: a teaspoon of soaked bonito flakes, a few flakes of salmon, or a few pieces of pickled plum. Close the rice over the filling and mold it into a triangular shape.\n" +
                    "7. Mold the rice firmly, pressing just hard enough to hold it together. Set the rice triangle down on one of its sides and cover the top peak with a strip of nori, shiny side out, like a roof. You can also make cylindrical shapes and wrap the nori around the middle.\n" +
                    "8. Sprinkle sesame seeds over the rice shapes.\n" +
                    "\n";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=zGH82EWJ-nU"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }
        else if(text.equals("sashimi"))
        {
            tvName.setText("SASHIMI");
            ivImg.setImageResource(R.drawable.sashimi);
            rep="INGREDIENTS\n" +
                    "1. 18 ounces red snapper fillet\n" +
                    "2. 1 teaspoon finely grated garlic\n" +
                    "3. 1 (3-inch) knob ginger, peeled and julienned very thinly and plunged briefly in cold water\n" +
                    "4. Menengi or chives\n" +
                    "5. 2 teaspoons white sesame seeds, toasted\n" +
                    "6. Yuzu Soy sauce, recipe follows\n" +
                    "7. 1 carrot curl, for garnish\n" +
                    "8. New Style Oil, recipe follows\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Cut fish fillet into paper-thin slices using the usu-zukuri cutting technique: Place fillet horizontally on chopping board with skin side up and tail end to left, steadying that side with fingers of left hand. Hold very sharp, long, thin-bladed pointed knife so that the top, blunt edge is inclined sharply to the right and, from the left side of fillet, start cutting paper-thin slices.\n" +
                    "2. Keep the blade at an acute angle to achieve a clean cut across the grain. The fish is sliced in one drawing stroke. Let the weight of the knife do the work as you draw the blade back toward yourself. Keep fingers of left hand clear.\n" +
                    "3.Arrange fish slices on serving plate. On each slice dab a little grated garlic and place ginger spears and a few menengi or chives.\n" +
                    "4.Sprinkle sesame seeds over fish.\n" +
                    "5. Drizzle yuzu soy sauce over top of entire arrangement and garnish with carrot curl.\n" +
                    "6.Just prior to serving, heat the New Style Oil in a small frying pan until just before it begins to smoke.\n" +
                    "7. Pour it over fish slices and serve.";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=TgoN7bsTFmU"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("tempura"))
        {
            tvName.setText("TEMPURA");
            ivImg.setImageResource(R.drawable.tempura);
            rep="INGREDIENTS\n" +
                    "1. 5 ounces unbleached cake flour\n" +
                    "2. 5 ounces white rice flour\n" +
                    "3. 1 1/2 quarts vegetable oil\n" +
                    "4. 1 large egg, beaten\n" +
                    "5. 1 1/2 cups cold seltzer water\n" +
                    "6. 1/2 cup vodka\n" +
                    "7. 5 to 6 ounces sweet potato, peeled and cut into 1/8-inch thick slices\n" +
                    "8. Kosher salt\n" +
                    "9. 1/4 pound fresh green beans, trimmed\n" +
                    "10. 8 stems flat-leaf parsley\n" +
                    "11. 1/2 pound shrimp, 31 to 35 count, head and tail-on, peeled and deveined\n" +
                    "12. 1/2 pound tilapia fillets, cut into 1-inch pieces\n" +
                    "13. Ice\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Whisk the cake flour and rice flour together in a medium glass bowl and divide it in half. Set aside.\n" +
                    "2.Heat the vegetable oil in a 5-quart Dutch oven over high heat until it reaches 375 degrees F on a deep-fry thermometer.\n" +
                    "3.Once the temperature reaches 365 degrees F, whisk the egg, seltzer water and vodka, in a medium mixing bowl and divide it in half.\n" +
                    "4. Put half of the mixture in the refrigerator to reserve. Pour half of the liquid mixture into half of the dry mixture and whisk to combine, about 10 to 15 seconds.\n" +
                    "5. Some lumps may remain. Set the glass bowl in a larger bowl lined with ice.\n" +
                    "6.Dip the sweet potatoes into the batter using tongs, drain for 2 to 3 seconds over the bowl, and then add to the hot oil. Adjust the heat to maintain between 375 and 400 degrees F. Fry 6 to 8 pieces, at a time, until puffy and very light golden, about 1 to 2 minutes\n" +
                    "7. Remove to a cooling rack lined with 3 layers of paper towels set over a half sheet pan. Sprinkle with salt, if desired.";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=k5DXVAa3eWY"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("spagetti"))
        {
            tvName.setText("SPAGETTI");
            ivImg.setImageResource(R.drawable.italian_spagetti);
            rep="INGREDIENTS:\n 1 pound 85% lean ground beef\n" +
                    "1 yellow onion chopped\n" +
                    "4 stalks celery chopped\n" +
                    "4 garlic cloves minced or pressed\n" +
                    "1 29- ounce can diced tomatoes\n" +
                    "1 29- ounce can tomato sauce\n" +
                    "1 6- ounce can tomato paste\n" +
                    "2 7- ounce cans sliced mushrooms\n" +
                    "1 cup red wine\n" +
                    "1 15- ounce can beef broth\n" +
                    "5-6 whole cloves\n" +
                    "2 bay leaves\n" +
                    "2 tablespoons sugar\n" +
                    "1/4 cup chopped fresh parsley or 4 teaspoons dried\n" +
                    "1 teaspoon basil\n" +
                    "1 teaspoon oregano\n" +
                    "1 teaspoon kosher salt\n" +
                    "1 teaspoon freshly ground black pepper\n" +
                    "1 pound dried spaghetti noodles\n" +
                    "grated Parmesan cheese" +
                    "" +
                    "" +
                    "" +
                    "\nMETHOD:\n" +
                    "In a large heavy bottomed stock pot over medium high heat, cook the ground beef until browned, about 5-7 minutes, stirring occasionally. Drain the rendered fat and add the meat back to the pot. Add the chopped onion, celery and garlic and cook until the vegetables soften, about 5-7 more minutes. Add the rest of the ingredients, stir, and bring to a boil. Reduce the heat to simmer, stir and cover with a lid, and cook for at least three hours on medium low heat, stirring occasionally.\n" +
                    "\n" +
                    "Cook the spaghetti according to the package directions in generously salted water. Drain and mix into the spaghetti sauce. Serve with grated or ground Parmesan cheese and chopped fresh parsley if desired.";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ErEy38dcCVg"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("pizza"))
        {
            tvName.setText("PIZZA");
            ivImg.setImageResource(R.drawable.italian_pizza);
            rep="INGREDIENTS\n" +
                    "1. Pizza Dough: Makes enough dough for two 10-12 inch pizzas\n" +
                    "2. 1 1/2 cups (355 ml) warm water (105°F-115°F)\n" +
                    "3. 1 package (2 1/4 teaspoons) of active dry yeast\n" +
                    "4. 3 3/4 cups (490 g) bread flour\n" +
                    "5. 2 Tbsp olive oil (omit if cooking pizza in a wood-fired pizza oven)\n" +
                    "6. 2 teaspoons salt\n" +
                    "7. 1 teaspoon sugar\n" +
                    "8. Pizza Ingredients\n" +
                    "9. Olive oil\n" +
                    "10. Cornmeal (to help slide the pizza onto the pizza stone)\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Proof the yeast: Place the warm water in the large bowl of a heavy duty stand mixer. Sprinkle the yeast over the warm water and let it sit for 5 minutes until the yeast is dissolved.After 5 minutes stir if the yeast hasn't dissolved completely. The yeast should begin to foam or bloom, indicating that the yeast is still active and alive.\n" +
                    "2.Make and knead the pizza dough: Using the mixing paddle attachment, mix in the flour, salt, sugar, and olive oil on low speed for a minute. Then replace the mixing paddle with the dough hook attachment.\n" +
                    "3.Let the dough rise: Spread a thin layer of olive oil over the inside of a large bowl. Place the pizza dough in the bowl and turn it around so that it gets coated with the oil. At this point you can choose how long you want the dough to ferment and rise. A slow fermentation (24 hours in the fridge) will result in more complex flavors in the dough. A quick fermentation (1 1/2 hours in a warm place) will allow the dough to rise sufficiently to work with. Cover the dough with plastic wrap.\n" +
                    "Slide the pizza off of the peel and on to the baking stone in the oven.\n";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=sv3TXMSv6Lw"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("risotto"))
        {
            tvName.setText("RISOTTO");
            ivImg.setImageResource(R.drawable.italian_rissoto);
            rep="INGREDIENTS\n" +
                    "1. 1 medium-size yellow onion\n" +
                    "2. 4 tablespoons butter (1/2 stick)\n" +
                    "3. 5 cups or more chicken broth, canned or homemade\n" +
                    "4. 2 cups Arborio rice (available in many supermarkets or specialty food stores)\n" +
                    "5. Salt and pepper to taste\n" +
                    "6. 3/4 cup freshly grated Parmesan cheese\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.In a saucepan, warm the broth over low heat.\n" +
                    "2.Warm 2 tablespoons olive oil in a large saucepan over medium-high heat. Stir in the mushrooms, and cook until soft, about 3 minutes. Remove mushrooms and their liquid, and set aside.\n" +
                    "3.Add 1 tablespoon olive oil to skillet, and stir in the shallots. Cook 1 minute. Add rice, stirring to coat with oil, about 2 minutes. When the rice has taken on a pale, golden color, pour in wine, stirring constantly until the wine is fully absorbed. Add 1/2 cup broth to the rice, and stir until the broth is absorbed. Continue adding broth 1/2 cup at a time, stirring continuously, until the liquid is absorbed and the rice is al dente, about 15 to 20 minutes.\n" +
                    "4.Remove from heat, and stir in mushrooms with their liquid, butter, chives, and parmesan. Season with salt and pepper to taste.1.In a saucepan, warm the broth over low heat.\n" +
                    "6.Warm 2 tablespoons olive oil in a large saucepan over medium-high heat. Stir in the mushrooms, and cook until soft, about 3 minutes. Remove mushrooms and their liquid, and set aside.\n" +
                    "7.Add 1 tablespoon olive oil to skillet, and stir in the shallots. Cook 1 minute. Add rice, stirring to coat with oil, about 2 minutes. When the rice has taken on a pale, golden color, pour in wine, stirring constantly until the wine is fully absorbed. Add 1/2 cup broth to the rice, and stir until the broth is absorbed. Continue adding broth 1/2 cup at a time, stirring continuously, until the liquid is absorbed and the rice is al dente, about 15 to 20 minutes";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=NKtR3KpS83w"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("panna_cota"))
        {
            tvName.setText("PANNA COTA");
            ivImg.setImageResource(R.drawable.italian_pannacotta);
            rep="INGREDIENTS\n" +
                    "1. 2 cups heavy cream\n" +
                    "2. 1 vanilla bean\n" +
                    "3. 1/2 cup sugar\n" +
                    "4. 1 1/2 teaspoons unflavored gelatin (about 1/2 packet)\n" +
                    "5. 1/2 cup whole milk\n" +
                    "6. 1/2 cup whole-milk Greek yogurt\n" +
                    "7. Sliced strawberries and fresh mint, for garnish (optional)\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "\n" +
                    "1. Place the cream in a saucepan. Halve the vanilla bean lengthwise; scrape out the seeds with a knife, then add the seeds and pod to the saucepan.\n" +
                    "2. Add the sugar and bring to a simmer over medium-low heat, stirring occasionally. Discard the vanilla pod.\n" +
                    "3. Sprinkle the gelatin over the milk in a bowl and let stand until the gelatin softens, about 5 minutes. Stir the gelatin mixture into the hot cream mixture until dissolved,\n" +
                    "then stir in the yogurt.\n" +
                    "4. Divide among six to eight 4-ounce ramekins, cover with plastic wrap and refrigerate until set, at least 6 hours or overnight.\n" +
                    "\n" +
                    "5. Dip each ramekin three-quarters of the way in warm water and invert onto a plate. Garnish each panna cotta with strawberries and mint, if desired.";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=qNCamYIFllk"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("pad_thai"))
        {
            tvName.setText("PAD THAI");
            ivImg.setImageResource(R.drawable.thai_padthai);
            rep="Ingredients\n" +
                    "\n" +
                    "8 ounces flat rice noodles\n" +
                    "3 Tablespoons oil\n" +
                    "3 cloves garlic , minced\n" +
                    "8 ounces uncooked shrimp, chicken, or extra-firm tofu , cut into small pieces\n" +
                    "2 eggs\n" +
                    "1 cup fresh bean sprouts\n" +
                    "1 red bell pepper , thinly sliced\n" +
                    "3 green onions , chopped\n" +
                    "1/2 cup dry roasted peanuts\n" +
                    "2 limes\n" +
                    "1/2 cup Fresh cilantro , chopped\n" +
                    "For the Pad Thai sauce:\n" +
                    "3 Tablespoons fish sauce\n" +
                    "1 Tablespoon low-sodium soy sauce\n" +
                    "5 Tablespoons light brown sugar\n" +
                    "2 Tablespoons rice vinegar * see note\n" +
                    "1 Tablespoon Sriracha hot sauce , or more, to taste\n" +
                    "2 Tablespoons creamy peanut butter , optional" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Method\n" +
                    "1.Cook noodles according to package instructions, just until tender.  Rinse under cold water.\n" +
                    "2.Mix the sauce ingredients together. Set aside.\n" +
                    "3.Heat 1½ tablespoons of oil in a large saucepan or wok over medium-high heat.\n" +
                    "4.Add the shrimp, chicken or tofu, garlic and bell pepper. The shrimp will cook quickly, about 1-2 minutes on each side, or until pink. If using chicken, cook until just cooked through, about 3-4 minutes, flipping only once.\n" +
                    "5.Push everything to the side of the pan. Add a little more oil and add the beaten eggs. Scramble the eggs, breaking them into small pieces with a spatula as they cook.\n" +
                    "6.Add noodles, sauce, bean sprouts and peanuts to the pan (reserving some peanuts for topping at the end). Toss everything to combine.\n" +
                    "7.Top with green onions, extra peanuts, cilantro and lime wedges. Serve immediately!";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=F5-nfxQjfZU"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("satay"))
        {
            tvName.setText("SATAY");
            ivImg.setImageResource(R.drawable.thai_satay);
            rep="INGREDIENTS\n" +
                    "1. 1/2 cup coconut milk\n" +
                    "2. 1 clove garlic, minced 1 teaspoon curry powder\n" +
                    "3. 1 1/2 teaspoons brown sugar\n" +
                    "4. 1/2 teaspoon salt\n" +
                    "5. 1/2 teaspoon ground black pepper\n" +
                    "6. 3/4 pound skinless, boneless chicken breast halves - cut into 1 inch strips\n" +
                    "7. 1 cup coconut milk\n" +
                    "8. 1 tablespoon curry powder\n" +
                    "9. 1/2 cup creamy peanut butter\n" +
                    "10. 1/4 cup brown sugar\n" +
                    "11. 2 tablespoons lime or lemon juice\n" +
                    "12. 1 teaspoon soy sauce\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "\n" +
                    "1.Stir together 1/2 cup coconut milk, garlic, 1 teaspoon curry powder, brown sugar, salt, and pepper until the sugar has dissolved. Toss marinade with the chicken, cover, and marinate for at least 2 hours.\n" +
                    "2.Bring 1 cup coconut milk, 1 tablespoon curry powder, peanut butter, chicken stock, and 1/4 cup brown sugar to a simmer in a saucepan over medium-high heat. Simmer for 5 minutes, stirring constantly, until smooth and thickened. Remove from heat and stir in lime juice and soy sauce; season to taste with salt.\n" +
                    "3.Preheat a grill for medium-high heat.\n" +
                    "4.Thread marinated chicken onto skewers, then grill 4 to 5 minutes per side, or until cooked through. Serve with warm peanut sauce.\n" +
                    "\n";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=aBAtC_Zp1Qo"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }


        else if(text.equals("thai_curry"))
        {
            tvName.setText("THAI CURRY");
            ivImg.setImageResource(R.drawable.thai_curry);
            rep="Ingredients" +
                    "" +
                    "1.17 ounces canned unsweetened coconut milk\n" +
                    "2.1-3 Tablespoons Thai green curry pastes \n" +
                    "3.1 teaspoon light brown sugar\n" +
                    "4.2 cloves garlic , minced\n" +
                    "5.juice from 2 limes\n" +
                    "6.salt and freshly ground black pepper , to taste\n" +
                    "7.For serving:\n" +
                    "8.steamed jasmine rice , brown rice, white rice, basmati rice\n" +
                    "9.fresh cilantro , chopped\n" +
                    "10.lime wedges\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Method\n" +
                    "1.Add the oats, egg and milk to a large mixing bowl. Mix together and set aside for 10 minutes.\n" +
                    "2.Add ground turkey, ginger, curry paste, fish sauce, sugar, cilantro, salt, garlic and green onions. Mix to combine.\n" +
                    "3.Scoop the meat mixture into balls, a little smaller than golf-ball size.\n" +
                    "4.In a large nonstick skillet, heat the vegetable oil over medium-high heat. \n" +
                    "5.When the oil is hot, place one layer of meatballs in the pan, leaving space between each-- I usually cook them in a few batches.\n" +
                    "6.Brown the meatballs, turning occasionally as they cook, until all sides are browned. They don't need to be cooked through, just browned on all sides.\n" +
                    "7.Remove the meatballs to a plate once they are browned. Use a paper towel to blot out any grease from the pan, without removing the browned bits from the bottom of the pan.\n" +
                    "8.Add coconut milk to the pan, scraping up those browned bits as your stir. Add green curry paste, brown sugar and garlic, stirring to combine.\n" +
                    "9.Add the meatballs back to the skillet. Simmer them in the sauce until cooked through, about 7-10 minutes.\n" +
                    "10.Stir in the lime juice. Add salt and pepper to taste. Serve over hot, cooked ric";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_t4bdNeTDvk"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("larb"))
        {
            tvName.setText("LARB");
            ivImg.setImageResource(R.drawable.thai_larb);
            rep="INGREDIENTS\n" +
                    "1. 2 lemons juiced 1 lime juiced\n" +
                    "2. 2 tablespoons fish sauce, or more to taste\n" +
                    "3. 1 tablespoon rice vinegar\n" +
                    "4. 1 teaspoon white sugar\n" +
                    "5. 1 teaspoon cayenne pepper\n" +
                    "6. 1 teaspoon lemon zest\n" +
                    "7. 1 pound ground turkey\n" +
                    "8. 1 clove garlic, minced 1 cup water to cover.\n" +
                    "9. 1/2 red onion, thinly sliced 1 carrot shredded\n" +
                    "10. 1/2 cup coarsely chopped chestnuts 3 Thai chile peppers, sliced\n" +
                    "11. 3 green onions, sliced\n" +
                    "12. 1/4 cup chopped fresh mint\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1.Whisk lemon juice, lime juice, fish sauce, rice vinegar, sugar, cayenne, and lemon zest together in a bowl until dressing is smooth.\n" +
                    "2.Spread ground turkey in a thin layer in a arge skillet; add garlic. Pour enough water into the skillet to cover the turkey; bring to a boil. Cook and stir turkey mixture, breaking the meat apart with a fork, until turkey is browned and crumbly, 7 to 10 minutes. Drain liquid and transfer turkey to a large glass bowl.\n" +
                    "3.Mix red onion, carrot, chestnuts, Thai chile peppers, green onions, mint, basil, and cilantro into turkey until well combined. Refrigerate mixture until chilled, about 30 minutes.\n" +
                    "4.Sprinkle rice powder and Thai chile flakes over turkey mixture and mix well.";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=elcphgkyYLY"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }

        else if(text.equals("nacho"))
        {
            tvName.setText("NACHOS");
            ivImg.setImageResource(R.drawable.mexican_nacho);
            rep="INGREDIENTS\n" +
                    "1. 1 bag white corn chips\n" +
                    "2. 3 cups freshly grated Monterey Jack cheese\n" +
                    "3. 1 jar jalapeno slices, optional\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1. Preheat the oven to 350 degrees F.\n" +
                    "1.Cook and stir ground beef in a skillet over medium heat until meat is crumbly and no longer pink, 5 to 10 minutes. Drain excess grease. Stir in taco seasoning mix and water and simmer until beef mixture has thickened, 8 to 10 minutes.\n" +
                    "2.Set the oven rack about 6 inches from the heat source and preheat the broiler. Line a baking sheet with aluminum foil. Spread tortilla chips on the prepared baking sheet; top with Cheddar cheese and dot with refried beans and ground beef mixture.\n" +
                    "3.Broil in the preheated oven until cheese is melted, watching carefully to prevent burning, 3 to 5 minutes. Top nachos with salsa, sour cream, black olives, green onions, and jalapeno peppers.";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=29FKpBO7T2M"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }
        else if(text.equals("tacos"))
        {
            tvName.setText("TACOS");
            ivImg.setImageResource(R.drawable.mexican_taco);
            rep="INGREDIENTS\n" +
                    "1. 12 ounces firm tofu, drained and cut into 8 slices\n" +
                    "2. 4 cups shredded coleslaw mix\n" +
                    "3. 1 small bunch radishes, thinly sliced\n" +
                    "4. 1/2 cup chopped fresh cilantro\n" +
                    "5. 1 bunch scallions, sliced\n" +
                    "6. 1 1/2 tablespoons extra-virgin olive oil\n" +
                    "7. 2 limes (1 zested and juiced, 1 cut into wedges)\n" +
                    "8. 1/4 cup nonfat plain Greek yogurt\n" +
                    "9. Kosher salt and freshly ground pepper\n" +
                    "10. 1 tablespoon taco seasoning\n" +
                    "11. 8 8-inch whole-wheat tortillas\n" +
                    "12. 1/4 cup shredded part-skim mozzarella or pepper jack cheese\n" +
                    "13. 1/4 cup jarred salsa verde\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1. Lay the tofu slices flat on a stack of paper towels; top with more paper towels, then put a heavy skillet on top to press out the excess water, about 10 minutes. Meanwhile, toss the coleslaw, radishes, cilantro, scallions, 1 tablespoon olive oil, the lime zest and half of the lime juice in a large bowl.\n" +
                    "2. Mix the yogurt with the remaining lime juice in a small bowl and season with salt and pepper.\n" +
                    "3. Brush the tofu on all sides with the remaining 1/2 tablespoon olive oil and sprinkle with the taco seasoning. Heat a nonstick skillet over medium-high heat, then add the tofu and cook until it begins to crisp, about 5 minutes; flip and cook 2 more minutes. Cut into strips.\n" +
                    "4. Toast the tortillas in a dry skillet, 1 minute per side, or wrap in a damp towel and microwave 1 minute. Fill with the tofu, cheese and slaw, then drizzle with the yogurt sauce and salsa. Serve with the lime wedges";
                        tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5yWOLxiniYo"));
                    startActivity(intent);
                }
            });
                        ivAudio.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                speak(rep);
                            }
                        });
            }
        else if(text.equals("enchiladas"))
        {
            tvName.setText("ENCHILADAS");
            ivImg.setImageResource(R.drawable.mexican_chicken_mole);
            rep="INGREDIENTS\n" +
                    "1. 12 ounces firm tofu, drained and cut into 8 slices\n" +
                    "2. 4 cups shredded coleslaw mix\n" +
                    "3. 1 small bunch radishes, thinly sliced\n" +
                    "4. 1/2 cup chopped fresh cilantro\n" +
                    "5. 1 bunch scallions, sliced\n" +
                    "6. 1 1/2 tablespoons extra-virgin olive oil\n" +
                    "7. 2 limes (1 zested and juiced, 1 cut into wedges)\n" +
                    "8. 1/4 cup nonfat plain Greek yogurt\n" +
                    "9. Kosher salt and freshly ground pepper\n" +
                    "10. 1 tablespoon taco seasoning\n" +
                    "11. 8 8-inch whole-wheat tortillas\n" +
                    "12. 1/4 cup shredded part-skim mozzarella or pepper jack cheese\n" +
                    "13. 1/4 cup jarred salsa verde\n" +
                    "\n" +
                    "\n" +
                    "METHOD\n" +
                    "1. Lay the tofu slices flat on a stack of paper towels; top with more paper towels, then put a heavy skillet on top to press out the excess water, about 10 minutes. Meanwhile, toss the coleslaw, radishes, cilantro, scallions, 1 tablespoon olive oil, the lime zest and half of the lime juice in a large bowl.\n" +
                    "2. Mix the yogurt with the remaining lime juice in a small bowl and season with salt and pepper.\n" +
                    "3. Brush the tofu on all sides with the remaining 1/2 tablespoon olive oil and sprinkle with the taco seasoning. Heat a nonstick skillet over medium-high heat, then add the tofu and cook until it begins to crisp, about 5 minutes; flip and cook 2 more minutes. Cut into strips.\n" +
                    "4. Toast the tortillas in a dry skillet, 1 minute per side, or wrap in a damp towel and microwave 1 minute. Fill with the tofu, cheese and slaw, then drizzle with the yogurt sauce and salsa. Serve with the lime wedges";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=JV_NZQTjrjM"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }
        else if(text.equals("salsa"))
        {
            tvName.setText("SALSA VERDE");
            ivImg.setImageResource(R.drawable.salsa_verde);
            rep="INGREDIENTS\n" +
                    "1 ½ pounds tomatillos (about 12 medium), husked and rinsed\n" +
                    "1 to 2 medium jalapeños, stemmed (omit for mild salsa, use 1 jalapeño for medium salsa and 2 jalapeños for hot salsa, note that spiciness will depend on heat of actual peppers used)\n" +
                    "½ cup chopped white onion (about ½ medium onion)\n" +
                    "¼ cup packed fresh cilantro leaves (more if you love cilantro)\n" +
                    "2 tablespoons to ¼ cup lime juice (1 to 2 medium limes, juiced), to taste\n" +
                    "½ to 1 teaspoon salt, to taste\n" +
                    "Optional variation: 1 to 2 diced avocados, for creamy avocado salsa verde\n" +
                    "METHOD\n" +
                    "Preheat the broiler with a rack about 4 inches below the heat source. Place the tomatillos and jalapeño(s) on a rimmed baking sheet and broil until they’re blackened in spots, about 5 minutes.\n" +
                    "Remove the baking sheet from the oven, carefully flip over the tomatillos and pepper(s) with tongs and broil for 4 to 6 more minutes, until the tomatillos are splotchy-black and blistered.\n" +
                    "Meanwhile, in a food processor or blender, combine the chopped onion, cilantro, 2 tablespoons lime juice and ½ teaspoon salt. Once the tomatillos are out of the oven, carefully transfer the hot tomatillos, pepper(s) and all of their juices into the food processor or blender.\n" +
                    "Pulse until the mixture is mostly smooth and no big chunks of tomatillo remain, scraping down the sides as necessary. Season to taste with additional lime juice and salt, if desired.\n" +
                    "The salsa will be thinner at first, but will thicken up after a few hours in the refrigerator, due to the naturally occurring pectin in the tomatillos. If you’d like to make creamy avocado salsa verde, let the salsa cool down before blending in 1 to 2 diced avocados (the more avocado, the creamier it gets).\n";
            tvRep.setText(rep);
            tvlink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=XHERKypDy-A"));
                    startActivity(intent);
                }
            });
            ivAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speak(rep);
                }
            });
        }
        
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Recipies.this,Cusines.class));
            }
        });
    }
    private void speak(String rep){
        String text=rep;

        float speed=0.75f;
        TtS.setSpeechRate(speed);
        TtS.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    protected void onDestroy() {
        if(TtS!=null)
        {
            TtS.stop();
            TtS.shutdown();
        }
        super.onDestroy();
    }
}
