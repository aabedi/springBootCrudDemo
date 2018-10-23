package com.example.crudSpringDemo.web;

import com.example.crudSpringDemo.domain.Program;
import com.example.crudSpringDemo.repositories.ProgramRepository;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProgramController {
    private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);
    private ProgramRepository programRepository;

    @Autowired
    public ProgramController(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @GetMapping("/programs")
    public List<Program> retrieveAllPrograms() {
        return programRepository.findAll();
    }

    @GetMapping("/programs/{id}")
    public Program retrieveProgram(@PathVariable long id) throws NotFoundException {
        Optional<Program> program = programRepository.findById(id);

        if (!program.isPresent())
            throw new NotFoundException("Element " + id + "not found.");

        return program.get();
    }

    @DeleteMapping("/programs/{id}")
    public void deleteProgram(@PathVariable long id) {
        programRepository.deleteById(id);
    }

    @PutMapping("/programs")
    public Program createProgram(@RequestBody @Valid Program program) {
        logger.info("Adding program " + program.getId());
        return programRepository.save(program);
    }

    @PostMapping("/programs")
    public Program updateProgram(@RequestBody Program program) {
        logger.info("Updating program " + program.getId());
        return programRepository.save(program);
    }
}
