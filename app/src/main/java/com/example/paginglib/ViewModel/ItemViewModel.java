package com.example.paginglib.ViewModel;

import androidx.appcompat.view.menu.MenuView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.paginglib.model.Item;
import com.example.paginglib.paging.ItemDataSource;
import com.example.paginglib.paging.ItemDataSourceFactory;

public class ItemViewModel extends ViewModel {
   public  LiveData<PagedList<Item>> itemPagedList;
    public LiveData<PageKeyedDataSource<Integer,Item>> liveDataSource;

    public ItemViewModel(){
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();

        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();
        PagedList.Config pagedListConfig = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE)
                .build();
        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory,pagedListConfig)).build();
    }
}
