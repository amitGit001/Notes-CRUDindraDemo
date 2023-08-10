import React from "react";

const ShowNotes=({notes})=>{

      return(
          <>

                  {notes.map((note) => (
                      <div key={note.id} className="card">
                          <div className="card-body">
                              <h5 className="card-title">{note.title}</h5>
                              <p className="card-text">{note.description}</p>
                          </div>
                      </div>
                  ))}
          </>
      )

}

export default ShowNotes