package pl.edoc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edoc.entity.Rating;
import pl.edoc.repository.RatingRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAll(int doctorId) {
        return ratingRepository.getAllByAppointment_Doctor_Id(doctorId);
    }

    public Rating getOne(int appointmentId) {
        Optional<Rating> result = ratingRepository.findById(appointmentId);
        return result.orElse(null);
    }
}
