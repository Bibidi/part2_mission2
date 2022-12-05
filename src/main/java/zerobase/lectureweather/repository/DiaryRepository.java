package zerobase.lectureweather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zerobase.lectureweather.domain.Diary;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    List<Diary> findAllByDate(LocalDate data);

    List<Diary> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    Diary getFirstByDate(LocalDate date);

    void deleteAllByDate(LocalDate date);
}
