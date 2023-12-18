package co.istad.sb8datajpa.mapper;

import co.istad.sb8datajpa.dto.CourseCreationDto;
import co.istad.sb8datajpa.dto.CourseDto;
import co.istad.sb8datajpa.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    // Map Course List to Course Dto List
    // Source: Course List
    // Target: Course Dto List
    List<CourseDto> mapCourseListToCourseDtoList(List<Course> courses);

    CourseDto mapCourseToCourseDto(Course course);

    @Mapping(source = "categoryId", target = "category.id")
    Course mapCreationDtoToCourse(CourseCreationDto creationDto);


}
