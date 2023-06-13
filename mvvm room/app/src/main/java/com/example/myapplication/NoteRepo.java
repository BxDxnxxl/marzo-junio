package com.example.myapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepo {

    private NoteDAO noteDAO;
    private LiveData<List<Note>> notelist;

    public NoteRepo(Application application){
        NoteDataBase noteDataBase = NoteDataBase.getInstance(application);
        noteDAO=noteDataBase.noteDAO();
        notelist=noteDAO.getAllData();
    }
    public void insertData(Note note){
        new InsertTask(noteDAO).execute(note);
    }
    public void updateData(Note note){
        new UpdateTask(noteDAO).execute(note);
    }
    public void deleteData(Note note){
        new DeleteTask(noteDAO).execute(note);
    }
    public LiveData<List<Note>> getAllData(){
        return notelist;
    }


    private static class InsertTask extends AsyncTask<Note, Void, Void>{
        private NoteDAO noteDAO;

        public InsertTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.insert(notes[0]);
            return null;
        }
    }

    private static class DeleteTask extends AsyncTask<Note, Void, Void>{
        private NoteDAO noteDAO;

        public DeleteTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.delte(notes[0]);
            return null;
        }
    }

    private static class UpdateTask extends AsyncTask<Note, Void, Void>{
        private NoteDAO noteDAO;

        public UpdateTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.update(notes[0]);
            return null;
        }
    }



}
