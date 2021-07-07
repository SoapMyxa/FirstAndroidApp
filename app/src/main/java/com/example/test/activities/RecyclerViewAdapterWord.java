package com.example.test.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.test.realm.Word;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/*
 * RecyclerViewAdapterWord: extends the Realm-provided
 * RealmRecyclerViewAdapter to provide data
 * for a RecyclerView to display
 * Realm objects on screen to a user.
 */
class RecyclerViewAdapterWord extends RealmRecyclerViewAdapter<Word, RecyclerViewAdapterWord.ViewHolder> {

    private final LayoutInflater inflater;

    RecyclerViewAdapterWord(Context context, OrderedRealmCollection<Word> data) {
        super(data, true);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = inflater.inflate(R.layout.dictionary_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Word obj = getItem(position);

        holder.theWord.setText(obj.getWord());
        holder.translate.setText(obj.getWord());
        holder.countTranslated.setText("0");
        holder.countErrors.setText("1");

        holder.data = obj;

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int index) {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView theWord;
        TextView translate;
        TextView countTranslated;
        TextView countErrors;
        public Word data;

        ViewHolder(View view) {
            super(view);

            theWord = view.findViewById(R.id.dictionary_item_word_eng);
            translate = view.findViewById(R.id.dictionary_item_word_translate);
            countTranslated = view.findViewById(R.id.dictionary_item_word_ok);
            countErrors = view.findViewById(R.id.dictionary_item_word_err);

        }
    }
}
