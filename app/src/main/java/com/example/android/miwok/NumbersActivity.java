package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class NumbersActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.number_one,
                R.drawable.number_one));
        words.add(new Word(R.string.number_two,
                R.drawable.number_two));
        words.add(new Word(R.string.number_three,
                R.drawable.number_three));
        words.add(new Word(R.string.number_four,
                R.drawable.number_four));
        words.add(new Word(R.string.number_five,
                R.drawable.number_five));
        words.add(new Word(R.string.number_six,
                R.drawable.number_six));
        words.add(new Word(R.string.number_seven,
                R.drawable.number_seven));
        words.add(new Word(R.string.number_eight,
                R.drawable.number_eight));
        words.add(new Word(R.string.number_nine,
                R.drawable.number_nine));
        words.add(new Word(R.string.number_ten,
                R.drawable.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
//                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                if (btSocket!=null)
                {
                    try
                    {
                        btSocket.getOutputStream().write("a".getBytes());
                    }
                    catch (IOException e)
                    {
//                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                }
//                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
//                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
//
//                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//                    // We have audio focus now.
//
//                    // Create and setup the {@link MediaPlayer} for the audio resource associated
//                    // with the current word
//                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
//
//                    // Start the audio file
//                    mMediaPlayer.start();
//
//                    // Setup a listener on the media player, so that we can stop and release the
//                    // media player once the sound has finished playing.
//                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
//                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
//        releaseMediaPlayer();
    }

//    /**
//     * Clean up the media player by releasing its resources.
//     */
//    private void releaseMediaPlayer() {
//        // If the media player is not null, then it may be currently playing a sound.
//        if (mMediaPlayer != null) {
//            // Regardless of the current state of the media player, release its resources
//            // because we no longer need it.
//            mMediaPlayer.release();
//
//            // Set the media player back to null. For our code, we've decided that
//            // setting the media player to null is an easy way to tell that the media player
//            // is not configured to play an audio file at the moment.
//            mMediaPlayer = null;
//
//            // Regardless of whether or not we were granted audio focus, abandon it. This also
//            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
//            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
//        }
//    }
}