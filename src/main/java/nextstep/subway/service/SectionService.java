package nextstep.subway.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import nextstep.subway.controller.dto.SectionCreateRequest;
import nextstep.subway.domain.*;
import nextstep.subway.repository.LineRepository;
import nextstep.subway.repository.SectionRepository;
import nextstep.subway.repository.StationRepository;

@Service
@RequiredArgsConstructor
public class SectionService {

    private final LineRepository lineRepository;
    private final SectionRepository sectionRepository;
    private final StationRepository stationRepository;

    @Transactional
    public Long createSection(Long lineId, SectionCreateRequest request) {
        Line line = findBy(lineId);
        Sections sections = findBy(line);
        Stations stations = new Stations(stationRepository.findByIdIn(request.stationIds()));
        Station upStation = stations.findBy(request.getUpStationId());
        Station downStation = stations.findBy(request.getDownStationId());

        sections.validateRegisterStationBy(upStation, downStation);

        sections.addSectionInMiddle(upStation, downStation, request.getDistance());
        Section section = sectionRepository.save(
                new Section(line, upStation, downStation, request.getDistance())
        );

        return section.id();
    }

    @Transactional
    public void deleteSection(Long lineId, Long stationId) {
        Line line = findBy(lineId);
        Sections sections = findBy(line);
        sections.validateDeleteSection(stationId);
        sectionRepository.deleteById(stationId);
    }

    private Line findBy(Long lineId) {
        return lineRepository.findById(lineId)
                .orElseThrow(() -> new IllegalArgumentException("노선이 존재하지 않습니다."));
    }

    private Sections findBy(Line line) {
        return new Sections(sectionRepository.findByLine(line));
    }
}