package com.mydogapplication;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Note.class, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context){

      if (instance == null){
          instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "Note_database").fallbackToDestructiveMigration().addCallback(roomCallback).build();
      }
      return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{

        private NoteDao noteDao;
        private PopulateDbAsyncTask(NoteDatabase db){
            noteDao = db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Maddie","Description 1","Race 1"));
            noteDao.insert(new Note("Frida","Description 2","Race 1"));
            noteDao.insert(new Note("Åke","Description 3","Race 1"));
            noteDao.insert(new Note("Stritter","Description 4","Race 1"));
            noteDao.insert(new Note("Bodil","Description 1","Race 1"));
            noteDao.insert(new Note("Hanne","Description 2","Race 1"));
            noteDao.insert(new Note("Felix","Description 3","Race 1"));
            noteDao.insert(new Note("Jens","Description 4","Race 1"));
            noteDao.insert(new Note("Samson","Description 1","Race 1"));
            noteDao.insert(new Note("Niels","Description 2","Race 1"));
            noteDao.insert(new Note("Kasper","Description 3","Race 1"));
            noteDao.insert(new Note("Frederik","Description 4","Race 1"));
            noteDao.insert(new Note("Thorsten","Description 1","Race 1"));
            noteDao.insert(new Note("Emil","Description 2","Race 1"));
            noteDao.insert(new Note("Frederik","Description 3","Race 1"));
            noteDao.insert(new Note("Mads","Description 4","Race 1"));
            noteDao.insert(new Note("Kristian","Description 1","Race 1"));
            noteDao.insert(new Note("Svend","Description 2","Race 1"));
            noteDao.insert(new Note("Kurt","Description 3","Race 1"));
            noteDao.insert(new Note("Jeppe","Description 4","Race 1"));
            noteDao.insert(new Note("Anton","Description 1","Race 1"));
            noteDao.insert(new Note("JohnJohn","Description 2","Race 1"));
            noteDao.insert(new Note("Mads","Description 3","Race 1"));
            noteDao.insert(new Note("Julie","Description 4","Race 1"));
            return null;
        }
    }
}
