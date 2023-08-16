import React, { useEffect, useState } from "react";
import axios from "axios";

import Notes from "./Notes";

const Form = () => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [notes, setNotes] = useState([]);
  const [displayAll, setDisplayAll] = useState(false);
  const [isUpdate, setIsUpdate] = useState(false);
  const [note, setNote] = useState({
    title: "",
    description: "",
    notesId: "",
  });

  useEffect(() => {
    fetchNotes();
  }, [notes]);

  const fetchNotes = async (e) => {
    // e.preventDefault();
    try {
      const response = await axios.get("http://localhost:8080/notes"); // Replace with your backend API endpoint for fetching notes
      setNotes(response.data);
      setDisplayAll(true);
    } catch (error) {
      setDisplayAll(true);
      console.error("Error fetching notes:", error);
    }
  };

  const addNote = async () => {
    if (title === "" || description === "") {
      alert("Title and description are required.");
      return;
    }
    try {
      const response = await axios.post("http://localhost:8080/notes", {
        title: title,
        description: description,
      }); // Replace with your backend API endpoint for fetching notes

      setDescription("");
      setTitle("");
    } catch (e) {
      alert("error occured ");
    }
  };
  const handleChange = (event) => {
    const { id, value } = event.target;
    // Update the respective state variable based on the input field's id
    if (id === "inputTitle") {
      setTitle(value);
    } else if (id === "desc") {
      setDescription(value);
    }
  };
  const noteById = async (notesId) => {
    try {
      const res = await axios.get(`http://localhost:8080/notes/${notesId}`);
      setNote({
        title: res.data.title,
        description: res.data.description,
        notesId: res.data.notesId,
      });

      setDescription(res.data.description);
      setTitle(res.data.title);

      setIsUpdate(true);
    } catch (e) {
      setIsUpdate(false);
      console.log("Error in get by id");
    }
  };

  const editNote = async (id) => {
    try {
      await noteById(id);
    } catch (e) {
      console.log("error in edit ................");
    }
  };
  const handleEdit = async () => {
    try {
      const res = await axios.put("http://localhost:8080/notes", {
        notesId: note.notesId,
        title: title,
        description: description,
      });
      setIsUpdate(false);
    } catch (e) {
      console.log("error in Handle edit ");
    }
  };
  const deletefun = async (id) => {
    try {
      console.log(id);
      const response = await axios.delete(`http://localhost:8080/notes/${id}`); // Replace with your backend API endpoint for fetching notes
      // console.log(response)
    } catch (e) {
      console.log(e);
    }
  };
  return (
    <>
      <form>
        <div className="mb-3">
          <label htmlFor="inputTitle" className="form-label">
            <b>Title</b>
          </label>
          <input
            type="text"
            className="form-control"
            id="inputTitle"
            value={title}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="inputDesc" className="form-label">
            <b>Description</b>
          </label>
          <textarea
            name="desc"
            id="desc"
            rows="3"
            className="form-control"
            value={description}
            onChange={handleChange}
          ></textarea>
        </div>
        {isUpdate == false ? (
          <button
            type="submit"
            className="btn btn-primary mx-3"
            onClick={addNote}
          >
            Add Note
          </button>
        ) : (
          <button
            type="submit"
            className="btn btn-primary mx-3"
            onClick={handleEdit}
          >
            update
          </button>
        )}
        <button type="btn" className="btn btn-primary" onClick={fetchNotes}>
          All Notes
        </button>
      </form>
      {displayAll === true ? (
        <Notes notes={notes} deletefun={deletefun} editNote={editNote} />
      ) : (
        "not found"
      )}
    </>
  );
};

export default Form;
