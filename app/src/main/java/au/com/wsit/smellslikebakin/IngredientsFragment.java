package au.com.wsit.smellslikebakin;

/**
 * Created by guyb on 8/06/16.
 */
public class IngredientsFragment extends CheckBoxesFragment
{
    @Override
    public String[] getContents(int index)
    {
        return Recipes.ingredients[index].split("`");
    }
}
