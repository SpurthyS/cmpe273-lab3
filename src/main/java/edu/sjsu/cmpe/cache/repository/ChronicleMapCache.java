package edu.sjsu.cmpe.cache.repository;

import edu.sjsu.cmpe.cache.domain.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class ChronicleMapCache implements CacheInterface {
    /**
     * In-memory map cache. (Key, Value) -> (Key, Entry)
     */
   // private final ConcurrentHashMap<Long, Entry> inMemoryMap;

    ConcurrentMap<Integer, CharSequence> map;

    public ChronicleMapCache(ConcurrentMap<Integer, CharSequence> map) {
        this.map = map;
    }

    @Override
    public Entry save(Entry newEntry) {
        checkNotNull(newEntry, "newEntry instance must not be null");
        map.putIfAbsent(newEntry.getKey(), newEntry.getValue());

        return newEntry;
    }

    @Override
    public Entry get(int key) {
        checkArgument(key > 0,
                "Key was %s but expected greater than zero value", key);
        Entry entry = new Entry();
        entry.setKey(key);
        entry.setValue(map.get(key));
        return entry;
    }

    @Override
    public List<Entry> getAll() {
        List<Entry> entriesList = new ArrayList<Entry>();

        for(Map.Entry<Integer, CharSequence> entry: map.entrySet()){
            Entry entryToList = new Entry();
            entryToList.setKey(entry.getKey());
            entryToList.setValue(entry.getValue());
            entriesList.add(entryToList);
        }
        return entriesList;
    }
}
