package com.app.jd9md12hw;

import com.app.jd9md12hw.Entity.Note;
import com.app.jd9md12hw.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class Jd9Md12HwApplication {

	@Autowired
	private NoteService noteService;

	public static void main(String[] args) {
		SpringApplication.run(Jd9Md12HwApplication.class, args);
	}

	@PostConstruct
	public void init() {
		noteService.add(new Note(1341l,"S1", "Something2"));
		noteService.add(new Note(123123l,"S2", "Something2"));
		noteService.add(new Note(124234l,"S3", "Something2"));
		noteService.add(new Note(9945646l,"S4", "Something2"));

		System.out.println(noteService.getById(1341l));

		noteService.deleteById(1341l);

		noteService.update(new Note(124234l,"S99", "Nothing"));

		List<Note> allNotes = noteService.listAll();
		for (Note note : allNotes) {
			System.out.println("Note ID: " + note.getId());
			System.out.println("Title: " + note.getTitle());
			System.out.println("Content: " + note.getContent());
			System.out.println();
		}
	}


}
