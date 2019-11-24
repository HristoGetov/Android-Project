package com.example.recipeapplication.DataAcess;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.recipeapplication.Model.Recipe;
import com.example.recipeapplication.R;

@Database(entities = Recipe.class, version = 1)
public abstract class RecipeDatabase extends RoomDatabase {
    private static RecipeDatabase instance;
    public abstract RecipeDAO noteDao();

    public static synchronized RecipeDatabase getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    RecipeDatabase.class,"recipe_database_9")
                    .addCallback(roomCallBack)
                    .fallbackToDestructiveMigration().build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallBack= new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDb(instance).execute();
        }
    };
    private static class PopulateDb extends AsyncTask<Void,Void,Void> {
        private RecipeDAO recipeDAO;

        private PopulateDb(RecipeDatabase db){
            recipeDAO=db.noteDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            recipeDAO.insert( new Recipe("Potato Soup","Slice the potatoes, slice the onion, put butter or oil in a pot, make them sweat for 5 minutes, please dont burn them. Then add potatoes, make higher the heat a bit (but not so much to burn the onion) and add stock slowly. After 5 minutes add the milk and all the stock left. Cook until reduced nicely, then mash. You can add additional butter, parmesan, spices. Nutmeg is good. I like some ancho chili powder or crispy guanciale on top. It's very good with hard bread. It's also very good with blue cheese, and you just need to add it at the end, off the heat. Le patate are a very good heat conductor and they will be hot enough to melt it.","\t"+"\t"+"• 2 onions, sliced" +"\n"+
                    "\t"+"\t"+"• 400 grams of potatoes, the wetter the better but it's not important"+
                    "\n"+
                    "\t"+"\t"+"• 200 dl of vegetable stock, but hot water will do it" +"\n"+
                    "\t"+"\t"+
                    "• 300 dl of milk, the fatter the better"
                    +"\n"+
                    "\t"+"\t"+"• 20 grams of butter or extra virgin olive oil, or nothing if you are on low fat." +
                    "\n"+
                    "\t"+"\t"+"• A small onion, or half normal sized one. Or no onions if you don't like them" +
                    "\n"+
                    "\t"+"\t"+"• 5 grams of Salt" ,"soup", R.drawable.potatosoup));
            recipeDAO.insert(new Recipe("Chicken Soup","Melt the butter in a large saucepan over a medium heat and gently fry the onions, celery and carrots until they start to soften.\n" +
                    "Stir in the flour and cook for 2 minutes. Add the chicken stock and bring the mixture to the boil, stirring as you do so. Season with salt and pepper, then reduce the heat until the mixture is simmering and simmer for 10 minutes, until the vegetables are tender.\n" +
                    "Add the cooked chicken and cook until heated through. Adjust the seasoning, stir in the parsley and serve.","\t"+"\t"+"• 2 onions, sliced•"+"\n"+
                    "\t"+"\t"+" 2 sticks celery, finely chopped"
                    +"\n"+
                    "\t"+"\t"+"• 2 carrots, finely diced" +
                    "\n"+
                    "\t"+"\t"+" •25g/2oz plain flour" +
                    "\n"+
                    "\t"+"\t"+"• 1.2 litres/2 pints chicken stock" +
                    "\n"+
                    "\t"+"\t"+"450g/1lb cooked chicken, skinned and shredded" +"• 1 tbsp chopped fresh parsley" +
                    "\n"+
                    "\t"+"\t"+"• salt and freshly ground black pepper","soup",R.drawable.chicken_soup));
            recipeDAO.insert( new Recipe("Vegetable Soup","ip 85g dried red lentils, 2 quartered and diced carrots, 3 sliced celery sticks and 2 sliced leeks into a large pan with 2 tbsp tomato purée, 1 tbsp fresh thyme leaves, 3 chopped garlic cloves, 1 tbsp vegetable bouillon powder and 1 heaped tsp ground coriander.\n" +
                    "Pour over 1½ litres boiling water from the kettle, then stir well. Cover and leave to simmer for 30 mins until the vegetables and lentils are tender.\n" +
                    "Ladle into bowls and eat straightaway, or if you like a really thick texture, blitz a third of the soup with a hand blender or in a food processor.",
                    "\t"+"\t"+" • 85g dried red lentils" + "\n"+
                            "\t"+ "\t"+"• • 2 small leeks, sliced" +"\n"+
                            "\t"+"\t"+"• 2 carrots, quartered lengthways then diced" +"\n"+
                            "\t"+"\t"+"• 2 tbsp tomato purée" +"\n"+
                            "\t"+"\t"+"• 1 tbsp fresh thyme leaves" +"\n"+
                            "\t"+"\t"+" • 3 large garlic cloves, chopped" +"\n"+
                            "\t"+"\t"+"• 1 tbsp vegetable bouillon powder" +"\n"+
                            "\t"+"\t"+"• 1 heaped tsp ground coriander" +"\n","soup"
                    , R.drawable.image_vegetable_soup));
            recipeDAO.insert( new Recipe("Beef Soup","Heat oil in a large pot. Add in the steak in batches making sure not to over crowd the pan. Cook until browned on both sides, about 2-3 minutes.\n" +
                    "Remove from the pan and set aside. Add in the onion, garlic, carrots, celery and potatoes. Saute for 3-4 minutes stirring occasionally.\n" +
                    "Add the remaining ingredients as well as the steak. Bring to a boil and simmer for 25-30 minute. Season with salt and pepper to taste and serve with fresh parsley, cheese and crushed red pepper flakes if desired.","\t"+"\t"+"• 1 cup water" + "\n"+
                    "\t"+ "\t"+"• crushed red pepper flakes" +"\n"+
                    "\t"+"\t"+"• parmesan cheese" +"\n"+
                    "\t"+"\t"+"• fresh parsley" +"\n"+
                    "\t"+"\t"+"• salt and pepper" +"\n"+
                    "\t"+"\t"+"• 1 tablespoon Italian seasoning" +"\n"+
                    "\t"+"\t"+"• 2 bay leaves" +"\n"+
                    "\t"+"\t"+"• 4 cups beef stock" +"\n"+
                    "\t"+"\t"+"• 1 tablespoon worcestershire sauce","soup", R.drawable.image_vegetable_beef_soup));

            recipeDAO.insert( new Recipe("Bread","In a large bowl, dissolve yeast and 1/2 teaspoon sugar in warm water; let stand until bubbles form on surface. Whisk together remaining 3 tablespoons sugar, salt, and 3 cups flour. Stir oil into yeast mixture; pour into flour mixture and beat until smooth. Stir in enough remaining flour, 1/2 cup at a time, to form a soft dough.\n" +
                    "Turn onto a floured surface; knead until smooth and elastic, 8-10 minutes. Place in a greased bowl, turning once to grease the top. Cover and let rise in a warm place until doubled, about 1-1/2 to 2 hours.\n" +
                    "Punch dough down. Turn onto a lightly floured surface; divide dough in half. Shape each into a loaf. Place in 2 greased 9x5-in. loaf pans. Cover and let rise until doubled, about 1 to 1-1/2 hours.\n" +
                    "Bake at 375° until golden brown and bread sounds hollow when tapped or has reached an internal temperature of 200°, 30-35 minutes. Remove from pans to wire racks to cool.",
                    "\t"+"\t"+"•  1 package active dry yeast" + "\n"+
                            "\t"+ "\t"+"• 2-1/4 cups warm water (110° to 115°)" +"\n"+
                            "\t"+"\t"+"• 3 tablespoons sugar plus 1/2 teaspoon sugar" +"\n"+
                            "\t"+"\t"+"• 1 tablespoon salt" +"\n"+
                            "\t"+"\t"+"• 2 tablespoons canola oil" +"\n","bread", R.drawable.image_bread));

            recipeDAO.insert(  new Recipe("Cake","You can begin by mixing sugar and butter together.\n" +
                    "         Whisk well until light and fluffy.\n" +
                    "          Then, take a manual whisker or a fork, if you do not have one.\n" +
                    "           Even electrical blenders are good. Once done, add the beaten eggs and blend well.\n" +
                    "           Beat further so that the mixture gets a light, white appearance.\n" +
                    "            Sift together the all purpose flour and baking soda.\n" +
                    "            It is done to evenly distribute the baking soda in flour.\n" +
                    "             Gradually, add this to the egg mixture. If required, add a little milk and mix till the batter is fluffy and soft.\n" +
                    "              Add vanilla essence and blend well. Vanilla essence is important to camouflage the smell of eggs.\n" +
                    "            Sprinkle some maida on a greased baking tin.It will prevent sticking of the cake to the base, you can also line it with a butter paper.\n" +
                    "            Pour the prepared mixture into the tin and place it in a pressure cooker.\n" +
                    "             Do not add water in the cooker and ensure that the tin does not touch the base of cooker.\n" +
                    "              You can keep the baking dish on an inverted steel plate.Increase the flame and pressure cook for two minutes.\n" +
                    "              Now remove the whistle and cook on low flame for 35-40 minutes.\n" +
                    "              If you are using an electric oven, cook at 180 degrees for 30-35 minutes.\n" +
                    "              Insert a knife or a metal skewer into the cake and if it comes out clean, then the cake is ready to devour in.\n" +
                    "              Remove from the oven/cooker and allow to cool on a wire rack",
                    "\t"+"\t"+"• 3 cup all purpose flour" + "\n"+
                            "\t"+ "\t"+"• 2 beaten eggs" +"\n"+
                            "\t"+"\t"+"• 2 teaspoon baking soda" +"\n"+
                            "\t"+"\t"+"• 2 teaspoon vanilla essence" +"\n"+
                            "\t"+"\t"+"• 2 cup powdered sugar" +"\n"+
                            "\t"+"\t"+"• 1 cup butter" +"\n"+
                            "\t"+"\t"+"• 2 cup milk" +"\n","desert",R.drawable.cake_image));

            recipeDAO.insert( new Recipe("Sour Cream Smashed Potatoes with Bacon Crumbs",
                    "Place the potatoes in a large pot, add enough cold water to cover and bring to a boil. Add 2 teaspoon salt, reduce heat and simmer until just tender, 15 to 18 minutes. Drain the potatoes and return them to the pot.\n" +
                            "While the potatoes are cooking, cook the bacon in a large skillet over medium heat, stirring occasionally, until crisp, 5 to 7 minutes. Toss with the nutmeg (if using), then transfer to a paper towel-lined plate and let cool. Refrigerate for up to 2 days.\n" +
                            "Add the half-and-half, sour cream, butter, and 1/2 teaspoon each salt and pepper to the potatoes and mash. Refrigerate for up to 2 days.\n" +
                            "To serve, place the potatoes in a glass bowl and microwave, covered, on medium, stirring occasionally until heated through. Or set the bowl over (but not in) a pot of simmering water and cook until heated through, 15 to 25 minutes. Warm the bacon in a skillet or in a 375 degrees F oven. Toss with the scalions and parsley. Sprinkle over the potatoes just before serving.",
                    "\t"+"\t"+"• 4 lb. potatoes, cut into 2-in. pieces" +"\n"+
                            "\t"+"\t"+"• kosher salt"+
                            "\n"+
                            "\t"+"\t"+"• black pepper" +"\n"+
                            "\t"+"\t"+
                            "• 6 oz. bacon, cut into 1/4-in. pieces"
                            +"\n"+
                            "\t"+"\t"+"• 1/8 tsp. freshly grated nutmeg (optional)" +
                            "\n"+
                            "\t"+"\t"+"• 1 c. half-and-half" +
                            "\n"+
                            "\t"+"\t"+"• 1 c. sour cream"+
                            "\n"+
                            "\t"+"\t"+"• 4 tbsp. unsalted butter"+
                            "\n"+
                            "\t"+"\t"+"• 2 scallions, thinly sliced"+
                            "\n"+
                            "\t"+"\t"+"• 1/2 c. fresh flat-leaf parsley, chopped","potato_dish", R.drawable.sour_cream_smashed_potatos));

            recipeDAO.insert( new Recipe("Stuffed Parmesan Potatoes",
                    "Pierce 3 scrubbed medium russet potatoes with fork.\n" +
                            "Place in 2-quart baking dish; cover with vented plastic wrap. Microwave on high 17 minutes or until tender. Cut each in half; scoop flesh into bowl. Cut slices off bottoms.\n" +
                            "Mash flesh with cream, 1/4 cup grated Parmesan cheese, basil, dried thyme, salt, and pepper. Spoon into potato halves; place in baking dish.\n" +
                            "Top with remaining 1/4 cup grated Parmesan. Bake 15 minutes in 425 degree F oven.",
                    "\t"+"\t"+"• 3 medium russet potatoes"+
                            "\n"+
                            "\t"+"\t"+"• 1/2 c. cream" +"\n"+
                            "\t"+"\t"+
                            "• 1/4 c. Grated Parmesan cheese"
                            +"\n"+
                            "\t"+"\t"+"• 5 basil leaves" +
                            "\n"+
                            "\t"+"\t"+"• tsp. dried thyme" +
                            "\n"+
                            "\t"+"\t"+"• 1/2 tsp. salt"+
                            "\n"+
                            "\t"+"\t"+"• tsp. Pepper"+
                            "\n"+
                            "\t"+"\t"+"• 1/2 c. Grated Parmesan cheese",
                    "potato_dish", R.drawable.stuffed_parmesan_potato));
            recipeDAO.insert( new Recipe("Extra Point Potato Skins",
                    "Preheat oven to 375�F. Pierce each potato with a fork several times. Place potatoes directly on oven rack and bake for 50 minutes, or until tender. Let cool, then slice each potato in half. Carefully scoop out pulp with a spoon into a bowl, leaving a 1/4-inch-thick shell.\n" +
                            "Cut each shell in half again and arrange on a foil-lined baking sheet. Season with salt and pepper. Bake potato quarters for 15 minutes to crisp them up\n" +
                            "Mash 1 cup of the potato pulp in a bowl and mix well with the sour cream, cheeses, green onion, parsley and sun-dried tomatoes. Divide the mixture evenly among the potato skins, pressing it into the shells. Sprinkle with more pepper and bake for 15 minutes, or until golden and crisp. Serve warm.",
                    "\t"+"\t"+"• 4 medium russet potatoes" +"\n"+
                            "\t"+"\t"+"• Salt and pepper"+
                            "\n"+
                            "\t"+"\t"+"• 1/4 c. sour cream" +"\n"+
                            "\t"+"\t"+
                            "• 1/2 c. Parmesan cheese"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 c. shredded mozzarella cheese" +
                            "\n"+
                            "\t"+"\t"+"• 1/4 c. sliced green onion" +
                            "\n"+
                            "\t"+"\t"+"• 2 tbsp. Fresh parsley"+
                            "\n"+
                            "\t"+"\t"+"• c. sun-dried tomatoes"
                    ,"potato_dish", R.drawable.sour_cream_smashed_potatos));
            recipeDAO.insert( new Recipe("Lemony Potato Salad",
                    "Place potatoes in a large, wide pot, cover with cold water, and bring to a boil. Add 2 tsp salt, reduce heat, and simmer until potatoes are just tender, 10 to 15 minutes. Drain and run under cold water to cool. \n" +
                            "Meanwhile, in a large bowl, whisk together sour cream, mayonnaise, mustard, lemon zest and juice, and 1/2 teaspoon each salt and pepper; stir in celery. Halve potatoes if large, then add to dressing and gently toss to combine. Fold in chives.",
                    "\t"+"\t"+"• 2 1/2 lb. baby potatoes (about 30)" +"\n"+
                            "\t"+"\t"+"• Kosher salt"+
                            "\n"+
                            "\t"+"\t"+"• Pepper" +"\n"+
                            "\t"+"\t"+
                            "• 1/4 c. sour cream"
                            +"\n"+
                            "\t"+"\t"+"• 2 tbsp. mayonnaise" +
                            "\n"+
                            "\t"+"\t"+"• 1 tbsp. whole-grain mustard" +
                            "\n"+
                            "\t"+"\t"+"• 1 tsp. grated lemon zest"+
                            "\n"+
                            "\t"+"\t"+"• 3 tbsp. fresh lemon juice"+
                            "\n"+
                            "\t"+"\t"+"• 2 stalks celery, finely chopped"+
                            "\n"+
                            "\t"+"\t"+"• 1/4 c. fresh chopped chives","potato_dish", R.drawable.lemony_potato_salad));

            recipeDAO.insert( new Recipe("Mashed Potato Souffle with cheese and bacon",
                    "In a large skillet over medium heat, cook bacon until very crisp, about 8 minutes. Transfer to paper-towel-lined plate. Set aside.\n" +
                            "In a medium pot, bring potatoes, 1 tablespoon salt, and enough cold water to cover by 2 inches to a boil. Reduce heat to medium and gently boil until potatoes are easily pierced with a paring knife, 12 to 15 minutes. Drain potatoes; then spread on a baking pan to dry, about 5 minutes. Using a ricer positioned over a large bowl, rice potatoes (or simply break them up finely with a fork).\n" +
                            "Preheat oven to 375 degrees F with rack in lower third of oven. Meanwhile, in a large bowl, whisk together half-and-half and egg yolks. Season with 1 teaspoon salt and 1/2 teaspoon pepper. Stir in reserved bacon and all but 2 tablespoons Emmentaler. Pour mixture over potatoes and stir until combined.\n" +
                            "In a small bowl and using an electric mixer, beat egg whites just until stiff peaks form. Fold egg whites into potato mixture until combined. Pour into a 2 1/2-quart baking dish or soufflé dish. Sprinkle with remaining Emmentaler. Bake until set and browned on top, 50 to 60 minutes.",
                    "\t"+"\t"+"• 8 oz. smoked applewood bacon" +"\n"+
                            "\t"+"\t"+"• 2 lb. russet potatoes"+
                            "\n"+
                            "\t"+"\t"+"• 1 c. half-and-half" +"\n"+
                            "\t"+"\t"+
                            "• 8 eggs"
                            +"\n"+
                            "\t"+"\t"+"• 8 oz. grated Emmentaler cheese" +
                            "\n"+
                            "\t"+"\t"+"• salt" +
                            "\n"+
                            "\t"+"\t"+"• Freshly ground pepper",
                    "potato_dish", R.drawable.mashed_potatoes_souffle));
            recipeDAO.insert( new Recipe("Buttermilk Mashed Potatoes",
                    "In covered 5-quart saucepot, combine potatoes, 1 teaspoon salt, and enough water to cover; heat to boiling on high. Reduce heat to low; simmer, covered, until fork-tender, about 20 minutes.\\n\" +\n" +
                            "        \"Meanwhile, in 12-inch nonstick skillet, melt margarine on medium. Add green onions and cook 3 to 5 minutes or just until tender, stirring occasionally. Add buttermilk; heat to lukewarm (don't worry if buttermilk separates; it comes back together in the mixing), stirring occasionally. Remove skillet from heat.\\n\" +\n" +
                            "        \"Drain potatoes. Return potatoes to saucepot and heat on low to dry slightly, about 2 minutes, tossing occasionally. With potato masher, coarsely mash potatoes. Add buttermilk mixture, 1 teaspoon salt, and 1/2 teaspoon freshly ground black pepper; continue mashing until almost smooth. Reheat potatoes if necessary. Makes about 8 1/2 cups.\\n\" +\n" +
                            "        \"To make Classic Parsley Mashed Potatoes: Prepare potatoes as above in step 1. Omit green onions and all of step 2. In step 3, coarsely mash potatoes with 1/2 cup margarine or butter (1 stick), cut up. Instead of buttermilk, add 1 1/2 cups whole milk, warmed, along with salt and pepper, and mash until potatoes are almost smooth. Stir in 1/4 cup chopped fresh parsley to serve. Makes about 8 cups.\\n\" +\n" +
                            "        \"\\n\" +\n" +
                            "        \"Each serving: About 245 calories, 4 g protein, 34 g carbohydrate, 11 g total fat (2 g saturated), 2 g fiber, 5 mg cholesterol, 440 mg sodium.                  \n" +
                            "        \"To make Mashed Potatoes with Root Vegetables: Prepare potatoes as above in step 1, but use only 2 pounds Yukon gold potatoes, \" +\n" +
                            "        \"and add 2 pounds (3 medium) celery root (celeriac), peeled and cut into 2-inch pieces, and 1 pound parsnips (6 medium), peeled and cut into 2-inch pieces. Omit green onions and all of step 2. In step 3, drain vegetables, then press through holes in bottom of rotary food mill into same saucepot instead of drying and mashing; increase margarine or butter to 5 tablespoons and stir in along with salt and pepper, and omit buttermilk. (If you do not have a food mill,\" +\n" +
                            "        \" you can mash vegetables with potato masher, but texture will not be quite as smooth.) Makes about 7 cups.\n",
                    "\t"+"\t"+"• 4 lb. Yukon gold potatoes" +"\n"+
                            "\t"+"\t"+"• Salt and pepper"+
                            "\n"+
                            "\t"+"\t"+"• 2 tbsp. margarine or butter" +"\n"+
                            "\t"+"\t"+
                            "• 3 bunch green onions"
                            +"\n"+
                            "\t"+"\t"+"• 1 1/4 c. buttermilk" ,
                    "potato_dish", R.drawable.mashed_potatoes));

            recipeDAO.insert( new Recipe("Vegetarian Fried Rice ",
                    "Heat olive oil in a large skillet on medium-high. Add mushrooms and cook, tossing occasionally, until golden brown, 3 to 4 minutes; transfer to a plate. \n" +
                            "Add sesame oil to the same skillet, then add kale and cook, tossing, 3 minutes. Stir in garlic and cook 1 minute. Add rice and cook, tossing occasionally, until heated through, about 2 minutes. \n" +
                            "Push rice to sides of the pan, pour eggs into open space, and cook, stirring often, until eggs are almost set, then fold in rice and cook 1 minute more. Toss with soy sauce, sriracha, and mushrooms.",
                    "\t"+"\t"+"• 1 tbsp. olive oil" +"\n"+
                            "\t"+"\t"+"• 4 oz. shiitake mushrooms, caps sliced (save stems for other use)"+
                            "\n"+
                            "\t"+"\t"+"• 1 tbsp. toasted sesame oil" +"\n"+
                            "\t"+"\t"+
                            "• 6 oz. kale, leaves thinly sliced (save stems for other use)"
                            +"\n"+
                            "\t"+"\t"+"• 2 cloves garlic, pressed"
                            +"\n"+
                            "\t"+"\t"+"• 4 c. cooked long-grain rice"
                            +"\n"+
                            "\t"+"\t"+"• 2 large eggs, beaten"
                            +"\n"+
                            "\t"+"\t"+"• 2 tbsp. low-sodium soy sauce"
                            +"\n"+
                            "\t"+"\t"+"• 1 tsp. sriracha",
                    "rice_dish", R.drawable.vegetarian_fried_rice));

            recipeDAO.insert( new Recipe("Healthy Fried Rice ",
                    "Heat oil in a large skillet over medium-high. Add chicken and cook, turning occasionally, until golden brown, 3 to 4 minutes.\n" +
                            "Add garlic and cook, stirring, 1 minute. Add rice and cook, stirring, until heated through, about 2 minutes. \n" +
                            "Pour eggs over top and gently stir to evenly coat and cook eggs and warm rice. Fold in carrot, edamame, and peas and cook until vegetables are just tender, 3 to 4 minutes. \n" +
                            "Stir in scallions, soy sauce, and sesame oil. Serve with additional scallions and sriracha if desired.",
                    "\t"+"\t"+"• 1 tbsp. olive oil" +"\n"+
                            "\t"+"\t"+"• 1 lb. boneless, skinless chicken breast, cut into 3/4-inch chunks"+
                            "\n"+
                            "\t"+"\t"+"• 2 cloves garlic, finely chopped" +"\n"+
                            "\t"+"\t"+
                            "• 4 c. steamed brown rice, cold (or leftover brown rice)"
                            +"\n"+
                            "\t"+"\t"+"• 2 large eggs, beaten"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 c. carrot, cut into thin matchsticks"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 c. frozen shelled edamame, thawed"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 c. frozen peas, thawed"
                            +"\n"+
                            "\t"+"\t"+"• 3 scallions, finely chopped, plus more sliced for serving"
                            +"\n"+
                            "\t"+"\t"+"• 2 tbsp. low-sodium soy sauce"
                            +"\n"+
                            "\t"+"\t"+"• 1 tsp. toasted sesame oil"
                            +"\n"+
                            "\t"+"\t"+"• Sriracha, for serving",
                    "rice_dish", R.drawable.healthy_fried_rice));

            recipeDAO.insert( new Recipe("Singapore-Style Chicken Fried Rice ",
                    "Heat 2 teaspoons of the oil in a large nonstick skillet or wok over medium-high heat. Add onion and bacon and stir-fry 4 minutes. Add bok choy; stir-fry 2 minutes or until leaves have wilted. Add bell pepper, ginger, and garlic; stir-fry until vegetables start to soften, about 4 minutes. Remove vegetables to a bowl.\n" +
                            "Return skillet to heat; add 1 tablespoon of the oil. When hot, add chicken and stir-fry 3 to 4 minutes or until cooked through. Remove chicken to bowl with vegetables.\n" +
                            "Return skillet to heat; add 1 teaspoon of the oil. When hot, add eggs and scramble just until set. Add eggs to bowl with vegetables and chicken.\n" +
                            "Return skillet to heat; add the remaining 1 tablespoon oil to skillet along with curry powder and cook over medium-high heat 30 seconds, stirring, until fragrant. Add rice and stir-fry until coated evenly. Cook rice undisturbed until bottom is slightly crisp, about 3 to 4 minutes.\n" +
                            "Return vegetables, chicken, and eggs to skillet; add soy sauce and stir-fry 3 minutes longer.",
                    "\t"+"\t"+"• 3 tbsp. canola oil" +"\n"+
                            "\t"+"\t"+"• 1 large onion"+
                            "\n"+
                            "\t"+"\t"+"• 1 package sliced Canadian bacon" +"\n"+
                            "\t"+"\t"+
                            "• 1 bunch bok choy"
                            +"\n"+
                            "\t"+"\t"+"• 1 large red bell pepper"
                            +"\n"+
                            "\t"+"\t"+"• 2 tsp. finely chopped, peeled fresh ginger"
                            +"\n"+
                            "\t"+"\t"+"• 3 clove garlic"
                            +"\n"+
                            "\t"+"\t"+"• 8 oz. skinless, boneless chicken"
                            +"\n"+
                            "\t"+"\t"+"• 3 large eggs"
                            +"\n"+
                            "\t"+"\t"+"• 1 1/2 tsp. madras curry powder"
                            +"\n"+
                            "\t"+"\t"+"• 4 c. cooked brown basmati rice"
                            +"\n"+
                            "\t"+"\t"+"• 2 tbsp. low-sodium soy sauce",
                    "rice_dish", R.drawable.singapore_fried_rice));

            recipeDAO.insert( new Recipe("Thai Pineapple Shrimp Fried Rice",
                    "Heat oil in a large nonstick skillet over medium-high heat; add shrimp and stir-fry 1 minute or until they turn pink on the outside but are only halfway cooked through. Remove shrimp to a plate with a slotted spoon.\n" +
                            "Add to skillet bell pepper, onion, garlic, and chile; stir-fry 3 minutes or until onion is translucent. Add eggs and stir-fry 30 seconds.\n" +
                            "Stir in 2 cups cooked rice, separating grains with back of spoon, and stir-fry 2 minutes. Add fish sauce, soy sauce, and lime juice; cook, stirring, for 2 minutes.\n" +
                            "Return shrimp to skillet with fresh pineapple and stir-fry 2 minutes or until shrimp are cooked through.\n" +
                            "Stir in cashews and cilantro.",
                    "\t"+"\t"+"• 3 tbsp. vegetable oil" +"\n"+
                            "\t"+"\t"+"• 1 lb. medium shrimp"+
                            "\n"+
                            "\t"+"\t"+"• 1 large red bell pepper" +"\n"+
                            "\t"+"\t"+
                            "• 1 medium Red Onion"
                            +"\n"+
                            "\t"+"\t"+"• 2 clove garlic"
                            +"\n"+
                            "\t"+"\t"+"• 1 red or green chile"
                            +"\n"+
                            "\t"+"\t"+"• 2 large eggs"
                            +"\n"+
                            "\t"+"\t"+"• 2 tbsp. fish sauce"
                            +"\n"+
                            "\t"+"\t"+"• 2 tbsp. Soy Sauce"
                            +"\n"+
                            "\t"+"\t"+"• 2 tbsp. lime juice"
                            +"\n"+
                            "\t"+"\t"+"• 1 1/2 c. diced fresh pineapple"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 c. dry-roasted cashews"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 c. torn cilantro leaves",
                    "rice_dish", R.drawable.thai_shrimp_fried_rice));
            recipeDAO.insert( new Recipe("Mediterranean Fried Rice",
                    "Finely grate the zest of the lemon, then cut the lemon in half. Heat 1 tablespoon oil in a large nonstick skillet over medium-high heat. Add the beef and cook, breaking it up with a spoon, until browned, 4 to 5 minutes (spoon off and discard any excess fat). Add the garlic and 1⁄4 teaspoon each salt and pepper and cook, stirring, for 1 minute; toss with the lemon zest. Transfer the beef to a bowl and squeeze the juice of half a lemon on top.\n" +
                            "Wash and dry the skillet, then heat the remaining tablespoon oil over medium-high heat. Add the rice and season with the cumin, coriander, and 1⁄4 teaspoon each salt and pepper. Cook, tossing occasionally, until the rice begins to crisp at the edges, about 5 minutes. Fold in the beef mixture and remove from heat.\n" +
                            "Meanwhile, squeeze the juice of the remaining lemon half into a medium bowl. Toss with the tomatoes, cucumber, scallions, and 1⁄4 teaspoon each salt and pepper. Fold in the mint and serve over the rice. Top with crumbled feta, if desired.",
                    "\t"+"\t"+"• 1 lemon" +"\n"+
                            "\t"+"\t"+"• 2 tbsp. extra-virgin olive oil"+
                            "\n"+
                            "\t"+"\t"+"• 1 lb. Lean ground beef or lamb" +"\n"+
                            "\t"+"\t"+
                            "• 2 cloves garlic, finely chopped"
                            +"\n"+
                            "\t"+"\t"+"• kosher salt"
                            +"\n"+
                            "\t"+"\t"+"• Freshly ground black pepper"
                            +"\n"+
                            "\t"+"\t"+"• 4 c. cooked long-grain rice (cold leftovers are best)"
                            +"\n"+
                            "\t"+"\t"+"• 1 tsp. ground cumin"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 tsp. ground coriander"
                            +"\n"+
                            "\t"+"\t"+"• 1 pt. grape or cherry tomatoes, halved"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 seedless cucumber, cut into 1/4 pieces"
                            +"\n"+
                            "\t"+"\t"+"• 2 Scallions, Sliced"
                            +"\n"+
                            "\t"+"\t"+"• 1/4 c. fresh mint, roughly chopped"
                            +"\n"+
                            "\t"+"\t"+"• Crumbled feta cheese, for serving",
                    "rice_dish", R.drawable.mediterranean));

            recipeDAO.insert( new Recipe("Pumpkin Cheese Bread",
                    "In a large bowl, stir together 3 1/2 cups flour, brown sugar, yeast, salt, and cayenne. Add 1 cup water, pumpkin, and cheese; stir to combine. (Dough will be slightly sticky.)\n" +
                            "Turn dough out onto a lightly floured surface and knead until it forms a smooth ball. (Add up to 1/4 cup more flour if needed.) Sprinkle a large bowl with flour and add ball of dough, turning to coat. Cover with plastic wrap and refrigerate overnight.\n" +
                            "Butter a 9- by 5-inch loaf pan with 1 tablespoon butter. Transfer dough to a lightly floured surface and use hands to flatten to a rectangle, about 9 by 10 inches. Roll dough into a log and place seam-side down in loaf pan. Cover loosely with plastic wrap or a kitchen towel and let rise at room temperature until almost doubled in volume, 1 to 1 1/4 hours.\n" +
                            "Preheat oven to 375 degrees F. Using a sharp knife, slash loaf down center. Brush loaf with egg wash. Bake until loaf sounds hollow when tapped, 40 to 50 minutes. Turn out of pan onto a wire rack to cool.",
                    "\t"+"\t"+"• 3 3/4 c. all-purpose flour" +"\n"+
                            "\t"+"\t"+"• 1 tbsp. light-brown sugar"+
                            "\n"+
                            "\t"+"\t"+"• 1 package rapid-rise yeast" +"\n"+
                            "\t"+"\t"+
                            "• 1 1/4 tsp. salt"
                            +"\n"+
                            "\t"+"\t"+"• tsp. cayenne pepper"
                            +"\n"+
                            "\t"+"\t"+"• 3/4 c. pumpkin puree"
                            +"\n"+
                            "\t"+"\t"+"• 4 oz. shredded sharp Cheddar"
                            +"\n"+
                            "\t"+"\t"+"• 1 tbsp. unsalted butter"
                            +"\n"+
                            "\t"+"\t"+"• 1 large egg",
                    "bread", R.drawable.pumpkin_cheese_bread));
            recipeDAO.insert( new Recipe("Cheddar-Scallion English Muffin Bread",
                    "Lightly coat two 8 1/2 x 4 1/2 x 2 1/4-in. loaf pans with nonstick spray. Dust each with 1 1/2 Tbsp cornmeal.\n" +
                            "Mix 3 cups flour, the scallions, yeast, salt, sugar, red pepper and baking soda in a large bowl.\n" +
                            "Heat milk and water until warm (105°F to 115°F). Stir into flour mixture, then stir in remaining 3 cups flour and 1 1/4 cups cheese.\n" +
                            "Divide dough evenly between pans (dough is very sticky). Lightly coat dough with nonstick spray then spray 2 sheets wax paper and invert over pans. Let rise in a warm draft-free place 45 minutes or until doubled.\n" +
                            "Heat oven to 400°F. Bake loaves 20 to 25 minutes until golden. Sprinkle with remaining 1/4 cup cheese and bake 5 minutes longer. Cool in pans on a wire rack 5 minutes before removing from pans to cool completely. Wrap tightly. To give, attach a note saying, \"Please toast.\" Store: Room temperature 3 days; freezer 2 months.\n" +
                            "Herb-Parmesan Variation: Omit scallions. Substitute 1 tsp coarsely ground black pepper for the red pepper. Stir 1 Tbsp each minced fresh or 1 tsp each dried rosemary and thyme into dry mixture. Substitute 1 cup grated Parmesan cheese for the Cheddar, reserving 2 Tbsp to sprinkle on top. If using fresh rosemary, reserve a few small sprigs to insert decoratively in tops of loaves before baking.",
                    "\t"+"\t"+"• 3 tbsp. cornmeal" +"\n"+
                            "\t"+"\t"+"• 6 c. all-purpose flour"+
                            "\n"+
                            "\t"+"\t"+"• 1/2 c. finely chopped scallions" +"\n"+
                            "\t"+"\t"+
                            "• 2 package active dry yeast"
                            +"\n"+
                            "\t"+"\t"+"• 2 tsp. salt"
                            +"\n"+
                            "\t"+"\t"+"• 1 tsp. sugar"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 tsp. ground red pepper (optional)"
                            +"\n"+
                            "\t"+"\t"+"• 1/4 tsp. baking soda"
                            +"\n"+
                            "\t"+"\t"+"• 2 c. milk"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 c. water"
                            +"\n"+
                            "\t"+"\t"+"• 6 oz. extra-sharp Cheddar cheese"
                            +"\n"+
                            "\t"+"\t"+"• Nonstick spray",
                    "bread", R.drawable.cheddar_scallion_english_muffin_bread));

            recipeDAO.insert( new Recipe("Corn Bread",
                    "Use 2 boxes (8 1/2 oz each) or 2 bags (6 1/2 oz each) corn muffin mix. Prepare according to package directions, adding one of the following ingredient combos to the mix.\n" +
                            "Bake in either a 9-in. pie plate, an 8- or 9-in. round or square baking pan, or muffin cups",
                    "\t"+"\t"+"• 1 c. drained canned corn kernels and 1/4 cup sliced scallions" +"\n"+
                            "\t"+"\t"+"• 1 c. shredded cheddar"+
                            "\n"+
                            "\t"+"\t"+"• 4 slice crumbled cooked bacon and 1/2 cup diced fresh tomato" +"\n"+
                            "\t"+"\t"+
                            "• 1 c. fresh or frozen blueberries",
                    "bread", R.drawable.corn_bread));
            recipeDAO.insert( new Recipe("Whole Wheat Sandwich Bread",
                    "Place the yeast, warm water, and honey in the bowl of a mixer. Stir together and let sit until foamy, about 10 minutes.\n" +
                            "To the yeast mixture, add the olive oil and orange juice, and combine using the paddle attachment. Add the dry ingredients and mix until all the flour is absorbed.\n" +
                            "Switch to the dough hook and knead for 4 minutes on medium speed until the dough is very stiff, silky, and dry.\n" +
                            "First Rise: Place the dough in a lightly oiled bowl, cover tightly with plastic wrap, and let rise until doubled in volume, about 1 1/2 hours.\n" +
                            "Second Rise: Flatten out the dough on a lightly floured surface to break up air bubbles. Roll out the dough with a rolling pin to a 12- by 24-inch rectangle. Fold it in thirds, like a business envelope. Repeat this process one more time. Then flatten the dough and place in a buttered 9 1/4-inch by 5 1/4-inch by 2 3/4-inch baking pan and brush the surface with melted butter.\n" +
                            "Let rise until 1 inch short of the top of the pan, about 1 1/2 hours. Bake for 1 hour. Carefully unmold onto a rack and cool completely.",
                    "\t"+"\t"+"• 2 1/4 tsp. granulated yeast" +"\n"+
                            "\t"+"\t"+"• 1 1/2 c. Warm water"+
                            "\n"+
                            "\t"+"\t"+"• 1 tbsp. organic buckwheat honey" +"\n"+
                            "\t"+"\t"+
                            "• 4 tbsp. olive oil"
                            +"\n"+
                            "\t"+"\t"+"• 2 tbsp. organic orange juice"
                            +"\n"+
                            "\t"+"\t"+"• 2 1/2 c. organic whole wheat flour"
                            +"\n"+
                            "\t"+"\t"+"• 1 tsp. kosher salt"
                            +"\n"+
                            "\t"+"\t"+"• 1 tbsp. freshly ground flax meal"
                            +"\n"+
                            "\t"+"\t"+"• 1 tbsp. organic sweet butter",
                    "bread", R.drawable.whole_bread));
            recipeDAO.insert( new Recipe("Crispy Corn Bread",
                    "Preheat oven to 450°F. Coat a 12-inch cast-iron skillet with lard; place in oven. Sift dry ingredients together into a large bowl; set aside.\n" +
                            "Whisk egg until frothy and then whisk in buttermilk. Add wet ingredients to dry ones and mix thoroughly. Whisk melted butter into batter. Remove skillet from oven when fat is smoking and swirl until fat coats bottom and sides.\n" +
                            "Pour batter into skillet and bake until top is golden brown and edge has pulled away from side of pan, about 15 minutes. Remove from oven, cut into 6 wedges in skillet, and serve hot. Or use for Corn Bread and Sausage Stuffing.",
                    "\t"+"\t"+"• 1 tbsp. lard or unsalted butter" +"\n"+
                            "\t"+"\t"+"• 1 1/2 c. stone-ground cornmeal"+
                            "\n"+
                            "\t"+"\t"+"• 1 tsp. baking powder" +"\n"+
                            "\t"+"\t"+
                            "• 1 tsp. baking soda"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 tsp. kosher salt"
                            +"\n"+
                            "\t"+"\t"+"• 1 tsp. sugar"
                            +"\n"+
                            "\t"+"\t"+"• 1 large egg"
                            +"\n"+
                            "\t"+"\t"+"• 1 1/2 c. buttermilk"
                            +"\n"+
                            "\t"+"\t"+"• 2 tbsp. unsalted butter",
                    "bread", R.drawable.corn_bread_stuffing));

            recipeDAO.insert( new Recipe("Olive Oil-Clementine Cake",
                    "Heat oven to 350°F. Coat a 9-in. cake pan with oil; line with parchment paper. In a bowl, toss almonds with 1 Tbsp oil and ⅓ cup sugar.\n" +
                            "In a medium bowl, whisk together flour, baking powder, and salt. Using an electric mixer, beat eggs and remaining ¾ cup sugar until light, fluffy, and more than doubled in volume, 4 to 5 minutes. With mixer on high, gradually add remaining ¾ cup oil.\n" +
                            "Reduce mixer speed to low and beat in clementine zest and juice. Gradually add flour mixture, beating just until incorporated.\n" +
                            "Spread batter in prepared pan. Sprinkle almond-sugar mixture on top and bake until golden brown and wooden pick inserted in center comes out clean, 40 to 45 minutes. Let cake cool 15 minutes, then transfer to a wire rack to cool completely. Top with candied clementines if desired.",
                    "\t"+"\t"+"• 3/4 c. 3/4 c. plus 1 Tbsp extra virgin olive oil, plus more for the pan" +"\n"+
                            "\t"+"\t"+"• 3/4 c. sliced almonds"+
                            "\n"+
                            "\t"+"\t"+"• 1/3 c. plus 3/4 cup granulated sugar" +"\n"+
                            "\t"+"\t"+
                            "• 1 1/2 c. all-purpose flour"
                            +"\n"+
                            "\t"+"\t"+"• 2 tsp. baking powder"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 tsp. kosher salt"
                            +"\n"+
                            "\t"+"\t"+"• 4 large eggs "
                            +"\n"+
                            "\t"+"\t"+"• 2 tsp. finely grated clementine zest plus 1/4 cup juice (from about 2 clementines)"
                            +"\n"+
                            "\t"+"\t"+"• Candied Clementines, for serving",
                    "desert", R.drawable.olive_oil_clementine_cake));

            recipeDAO.insert( new Recipe("Sticky Cranberry-Toffee Cake",
                    "Heat oven to 350°F. Lightly grease an 8-in. square cake pan, then line bottom with parchment paper.\n" +
                            "In a heatproof medium bowl, place dates, then cover them with boiling water. Stir in baking soda and let sit until dates are soft enough to break up easily with a fork, about 5 minutes. Mash slightly with fork, then set aside.\n" +
                            "In a large bowl, stir together melted butter and sugar, then whisk in eggs, vanilla, and salt. Add flour, baking powder, and softened date mixture and stir well to combine. Stir in chopped cranberries.\n" +
                            "Bake until cake springs back slowly when gently pressed in the center, 35 to 45 minutes. Let cool in the pan 10 minutes, then transfer to a wire rack set over a baking sheet to cool completely.\n" +
                            "Use a wooden skewer to poke about 12 holes in cake, then pour half of butterscotch sauce over top. Serve with whipped cream or ice cream and remaining butterscotch sauce.",
                    "\t"+"\t"+"• 4 tbsp. unsalted butter, melted, plus more for pan" +"\n"+
                            "\t"+"\t"+"• 8 oz. pitted Medjool dates, roughly chopped"+
                            "\n"+
                            "\t"+"\t"+"• 1 c. boiling water" +"\n"+
                            "\t"+"\t"+
                            "• 1 tsp. baking soda"
                            +"\n"+
                            "\t"+"\t"+"• 3/4 c. packed dark brown sugar"
                            +"\n"+
                            "\t"+"\t"+"• 2 large eggs"
                            +"\n"+
                            "\t"+"\t"+"• 2 tsp. pure vanilla extract"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 tsp. flaky sea salt"
                            +"\n"+
                            "\t"+"\t"+"• 1 c. all-purpose flour"
                            +"\n"+
                            "\t"+"\t"+"• 1 tsp. baking powder"
                            +"\n"+
                            "\t"+"\t"+"• 1 1/2 c. fresh or frozen cranberries, roughly chopped"
                            +"\n"+
                            "\t"+"\t"+"• Salted Butterscotch Sauce"
                            +"\n"+
                            "\t"+"\t"+"• Whipped cream or ice cream, for serving",
                    "desert", R.drawable.sticky_cranberry_toffee_date_cake));
            recipeDAO.insert( new Recipe("Mont Blanc",
                    "Heat oven to 350°F. In a food processor, process chestnuts to form fine crumbs; transfer half to a bowl.\n" +
                            "Add cookies to food processor and pulse to form fine crumbs. Add melted butter and pulse to combine. Transfer crumbs to a 9-in. pie plate and press into bottom and up side. Bake until golden brown and set, 20 to 25 minutes. Let cool.\n" +
                            "Meanwhile, clean the food processor. When crust is cool, make filling: Melt chocolate per pkg. directions. Process reserved chestnut crumbs, ricotta, and melted chocolate 3 minutes. Spoon evenly into cooled crust, then refrigerate until set, at least 35 minutes.\n" +
                            "When ready to serve, beat cream into stiff peaks and spread on top of pie. Sprinkle with chocolate shavings if desired.",
                    "\t"+"\t"+"• 2 c. roasted chestnuts (about 10 oz)" +"\n"+
                            "\t"+"\t"+"• 4 tbsp. unsalted butter, melted"+
                            "\n"+
                            "\t"+"\t"+"• 8 oz. semisweet chocolate " +"\n"+
                            "\t"+"\t"+
                            "• 1 15-oz container whole milk ricotta cheese"
                            +"\n"+
                            "\t"+"\t"+"• 1 c. heavy cream, cold"
                            +"\n"+
                            "\t"+"\t"+"• Bittersweet chocolate curls, for serving"
                            +"\n"+
                            "\t"+"\t"+"• 19 oz. shortbread cookies (we used Lorna Doone; about 35 cookies)",
                    "desert", R.drawable.mont_blanc));
            recipeDAO.insert( new Recipe("Key Lime and Blueberry Pies in Jars",
                    "Heat oven to 375 degrees F. Line an 8 1/2 X 4 1/2 inch loaf pan with parchment paper, leaving a 3-inch overhang on the two long sides.\n" +
                            "In a food processor, pulse the graham crackers and sugar to form fine crumbs (you should have 1 3/4 cups crumbs total). Add the butter and pulse to combine.\n" +
                            "Spoon 1 tablespoon each into eight 4-ounce jars, gently pressing them into the bottom. Transfer the jars to a large rimmed baking sheet. Press the remaining graham mixture into the bottom of the prepared loaf pan and transfer the pan to the baking sheet. Bake until the crusts are golden brown, 12 to 15 minutes. Transfer to a wire rack to cool. Reduce oven temperature to 350 degrees F.\n" +
                            "In a large bowl, whisk together the milk and egg yolks. Add the lime juice and whisk to combine. Divide the mixture among the cooled jars (3 tablespoons per jar) and bake until just set, 10 to 12 minutes. Transfer to a wire rack and let cool, then refrigerate until ready to serve (or up to 2 days).\n" +
                            "Using en electric mixer, beat the heavy cream in a medium bowl until stiff peaks form. Roughly break up the remaining graham cracker crust (you will have some left over) and form layers in the jars using the cream, blueberries, lime zest, and broken grahams.",
                    "\t"+"\t"+"• 12 graham crackers" +"\n"+
                            "\t"+"\t"+"• 2 tbsp. granulated sugar"+
                            "\n"+
                            "\t"+"\t"+"• 6 tbsp. unsalted butter, melted" +"\n"+
                            "\t"+"\t"+
                            "• 1 (14 ounce) can sweetened condensed milk"
                            +"\n"+
                            "\t"+"\t"+"• 4 large egg yolks"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 c. fresh lime juice (from about 4 limes)"
                            +"\n"+
                            "\t"+"\t"+"• 1/2 c. heavy cream"
                            +"\n"+
                            "\t"+"\t"+"• 1 c. blueberries"
                            +"\n"+
                            "\t"+"\t"+"• Grated lime zest, for serving",
                    "desert", R.drawable.lime_blueberry_pies_in_jars));


            return null;
        }
    }

}

