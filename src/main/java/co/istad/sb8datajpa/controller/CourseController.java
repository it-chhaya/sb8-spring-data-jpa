package co.istad.sb8datajpa.controller;

import co.istad.sb8datajpa.dto.CourseCreationDto;
import co.istad.sb8datajpa.dto.CourseDto;
import co.istad.sb8datajpa.entity.Course;
import co.istad.sb8datajpa.mapper.CourseMapper;
import co.istad.sb8datajpa.repository.CourseRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNew(@Valid @RequestBody CourseCreationDto creationDto) {
        Course course = courseMapper.mapCreationDtoToCourse(creationDto);
        course.setCreatedAt(LocalDateTime.now());
        course.setIsDelete(false);
        course.setUpdatedAt(null);
        courseRepository.save(course);
    }

    @GetMapping
    Page<CourseDto> findList(@RequestParam(required = false, defaultValue = "0") int pageNumber,
                             @RequestParam(required = false, defaultValue = "4") int pageSize) {
        Sort sortById = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortById);
        Page<Course> courses = courseRepository.findAll(pageable);
        return courses.map(courseMapper::mapCourseToCourseDto);
    }

}
