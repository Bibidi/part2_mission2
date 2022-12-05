package zerobase.lectureweather.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.lectureweather.domain.Diary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DiaryRepositoryTest {

    @Mock
    private DiaryRepository diaryRepository;

    @Test
    void successFindAllByDate() {
        //given
        LocalDate now = LocalDate.now();
        Diary diary = new Diary().builder()
                .id(1)
                .date(now)
                .icon("icon")
                .temperature(27.4)
                .text("hello")
                .weather("cloud").build();

        ArrayList<Diary> diaries = new ArrayList<>();
        diaries.add(diary);
        given(diaryRepository.findAllByDate(any()))
                .willReturn(diaries);

        //when
        Diary result = diaryRepository.findAllByDate(now).get(0);

        //then
        assertEquals(diary.getId(), result.getId());
        assertEquals(diary.getDate(), result.getDate());
        assertEquals(diary.getText(), result.getText());
        assertEquals(diary.getWeather(), result.getWeather());
        assertEquals(diary.getIcon(), result.getIcon());
        assertEquals(diary.getTemperature(), result.getTemperature());
    }
}