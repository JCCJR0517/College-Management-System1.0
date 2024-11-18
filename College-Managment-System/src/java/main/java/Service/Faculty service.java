@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new RuntimeException("Faculty not found"));
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Long id, Faculty updatedFaculty) {
        Faculty faculty = getFacultyById(id);
        faculty.setName(updatedFaculty.getName());
        faculty.setEmail(updatedFaculty.getEmail());
        faculty.setDepartment(updatedFaculty.getDepartment());
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
