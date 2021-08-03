package test.BannerCategory.service;

import org.springframework.stereotype.Service;
import test.BannerCategory.model.Banner;
import test.BannerCategory.model.Request;
import test.BannerCategory.repository.BannerRepository;
import test.BannerCategory.repository.RequestRepository;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @SuppressWarnings("rawtypes")
    public Iterable findAll() {
        return requestRepository.findAll();
    }

    public Request save(Request request) {
        return requestRepository.save(request);
    }

    public void delete(int id) {
        requestRepository.deleteById(id);
    }

    public Request update(Request request) {
        return requestRepository.save(request);
    }
}
