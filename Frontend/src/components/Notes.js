import React from "react";

export default function Notes({ notes, deletefun, editNote }) {
  return (
    <>
      {notes.map((note) => (
        <div key={note.notesId} className="card w-75 mb-3">
          <div className="card-body">
            <h5 className="card-title">{note.title}</h5>
            <p className="card-text">{note.description}</p>
            {/*<h3>{note.notesId}</h3>*/}
            <a
              href="#"
              className="btn btn-primary mx-3 "
              id={note.notesId}
              onClick={() => editNote(note.notesId)}
            >
              Edit
            </a>
            <a
              href="#"
              className="btn btn-primary"
              id={note.notesId}
              onClick={() => deletefun(note.notesId)}
            >
              Delete
            </a>
          </div>
        </div>
      ))}
    </>
  );
}
