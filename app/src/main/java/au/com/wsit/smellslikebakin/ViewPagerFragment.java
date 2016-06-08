package au.com.wsit.smellslikebakin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by guyb on 7/06/16.
 */
public class ViewPagerFragment extends Fragment
{
    public static final String KEY_RECIPE_INDEX = "recipe_index";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        final CheckBoxesFragment ingredientsFragment = new IngredientsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);

        ingredientsFragment.setArguments(bundle);

        final CheckBoxesFragment directionsFragment = new DirectionsFragment();
        bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        directionsFragment.setArguments(bundle);


        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager())
        {
            @Override
            public Fragment getItem(int position)
            {
                if (position == 0)
                {
                    return ingredientsFragment;
                }
                else
                {
                    return directionsFragment;
                }
            }

            @Override
            public int getCount()
            {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position)
            {
                if(position == 0)
                {
                    return "Ingredients";
                }
                else
                {
                    return "Directions";
                }
            }
        });

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);


        return view;
    }

    @Override
    public void onStop()
    {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
