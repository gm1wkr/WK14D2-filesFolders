package com.example.filesystem.components;


import com.example.filesystem.models.File;
import com.example.filesystem.models.Folder;
import com.example.filesystem.models.User;
import com.example.filesystem.repositories.FileRepository;
import com.example.filesystem.repositories.FolderRepository;
import com.example.filesystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public void run(ApplicationArguments args){
        User bob = new User("bob");
        User jane = new User("Jane");
        userRepository.save(bob);
        userRepository.save(jane);

        Folder downloads = new Folder("downloads", bob);
        Folder pictures = new Folder("pictures", jane);
        folderRepository.save(downloads);
        folderRepository.save(pictures);

        File file = new File("comment", "txt", 1024, downloads);
        File picture1 = new File("pic-1", "jpeg", 1024345, pictures);
        File picture2 = new File("pic-2", "jpeg", 1028674, pictures);
        fileRepository.save(file);
        fileRepository.save(picture1);
        fileRepository.save(picture2);
    }
}
