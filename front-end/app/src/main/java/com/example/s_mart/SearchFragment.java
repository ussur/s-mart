package com.example.s_mart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchFragment extends Fragment{

   public SearchFragment() {
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_search_main, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList dataSearch = new ArrayList<DataSearch>();
        for (int i = 0; i <DataSearchInformation.id.length; i++)
        {
            dataSearch.add(
                    new DataSearch
                            (
                                    DataSearchInformation.nameArray[i],
                                    DataSearchInformation.priceArray[i],
                                    DataSearchInformation.categoryArray[i],
                                    DataSearchInformation.ratingArray[i]
                            ));
        }
        mListAdapter = new ListAdapter(dataSearch);
        mRecyclerView.setAdapter(mListAdapter);
        return view;
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

        private ArrayList<DataSearch> dataList;

        public ListAdapter(ArrayList<DataSearch> dataSearch)
        {
            this.dataList = dataSearch;
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            TextView textViewName;
            TextView textViewPrice;
            TextView textViewCategory;
            TextView textViewRating;

            public ViewHolder(View itemView)
            {
                super(itemView);
                this.textViewName = (TextView) itemView.findViewById(R.id.name);
                this.textViewPrice = (TextView) itemView.findViewById(R.id.price);
                this.textViewCategory = (TextView) itemView.findViewById(R.id.category);
                this.textViewRating = (TextView) itemView.findViewById(R.id.rating);
            }
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_search, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position)
        {
            holder.textViewName.setText(dataList.get(position).getName());
            holder.textViewPrice.setText(dataList.get(position).getPrice());
            holder.textViewCategory.setText(dataList.get(position).getCategory());
            holder.textViewRating.setText(dataList.get(position).getRating());

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Fragment fragment = new ProductFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fl_content, fragment);
                    transaction.commit();
                }
            });
        }

        @Override
        public int getItemCount()
        {
            return dataList.size();
        }
    }
}
