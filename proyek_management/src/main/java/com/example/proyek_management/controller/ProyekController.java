// package com.example.proyek_management.controller;

// import com.example.proyek_management.model.Proyek;
// import com.example.proyek_management.service.ProyekService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/proyek")
// public class ProyekController {

//     @Autowired
//     private ProyekService proyekService;

//     @GetMapping
//     public ResponseEntity<List<Proyek>> getAllProyek() {
//         List<Proyek> proyekList = proyekService.getAllProyek();
//         return ResponseEntity.ok(proyekList);
//     }

//     @PostMapping
//     public ResponseEntity<Proyek> createProyek(@RequestBody Proyek proyek) {
//         try {
//             Proyek savedProyek = proyekService.saveProyek(proyek);
//             return ResponseEntity.ok(savedProyek);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return ResponseEntity.status(500).body(null);
//         }
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Proyek> updateProyek(@PathVariable Integer id, @RequestBody Proyek proyek) {
//         proyek.setId(id); // Ensure the ID in the path matches the ID in the request body
//         Proyek updatedProyek = proyekService.updateProyek(proyek);
//         return ResponseEntity.ok(updatedProyek);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteProyek(@PathVariable Integer id) {
//         try {
//             proyekService.deleteProyek(id);
//             return ResponseEntity.noContent().build();
//         } catch (Exception e) {
//             // Log the exception and return a suitable error response
//             e.printStackTrace();
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//         }
//     }

// }

package com.example.proyek_management.controller;

import com.example.proyek_management.model.Proyek;
import com.example.proyek_management.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @GetMapping
    public ResponseEntity<List<Proyek>> getAllProyek() {
        try {
            List<Proyek> proyekList = proyekService.getAllProyek();
            return ResponseEntity.ok(proyekList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Proyek> createProyek(@RequestBody Proyek proyek) {
        try {
            Proyek savedProyek = proyekService.saveProyek(proyek);
            return ResponseEntity.ok(savedProyek);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Integer id, @RequestBody Proyek proyek) {
        try {
            proyek.setId(id); // Ensure the ID in the path matches the ID in the request body
            Proyek updatedProyek = proyekService.updateProyek(proyek);
            return ResponseEntity.ok(updatedProyek);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyek(@PathVariable Integer id) {
        try {
            proyekService.deleteProyek(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
