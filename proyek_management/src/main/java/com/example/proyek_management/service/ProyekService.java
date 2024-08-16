package com.example.proyek_management.service;

import com.example.proyek_management.model.Lokasi;
import com.example.proyek_management.model.Proyek;
import com.example.proyek_management.repository.LokasiRepository;
import com.example.proyek_management.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    public List<Proyek> getAllProyek() {
        try {
            return proyekRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Proyek saveProyek(Proyek proyek) {
        Set<Lokasi> validLokasiSet = new HashSet<>();

        for (Lokasi lokasi : proyek.getLokasiSet()) {
            Optional<Lokasi> lokasiOpt = lokasiRepository.findById(lokasi.getId());
            if (lokasiOpt.isPresent()) {
                validLokasiSet.add(lokasiOpt.get());
            } else {
                throw new RuntimeException("Lokasi dengan ID " + lokasi.getId() + " tidak ditemukan");
            }
        }

        proyek.setLokasiSet(validLokasiSet);
        return proyekRepository.save(proyek);
    }

    public Proyek updateProyek(Proyek proyek) {
        if (!proyekRepository.existsById(proyek.getId())) {
            throw new RuntimeException("Proyek with ID " + proyek.getId() + " does not exist");
        }
        return proyekRepository.save(proyek);
    }

    public void deleteProyek(Integer id) {
        if (!proyekRepository.existsById(id)) {
            throw new RuntimeException("Proyek with ID " + id + " does not exist");
        }
        proyekRepository.deleteById(id);
    }

}
