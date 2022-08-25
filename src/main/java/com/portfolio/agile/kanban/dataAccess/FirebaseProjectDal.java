package com.portfolio.agile.kanban.dataAccess;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.portfolio.agile.kanban.entity.MyProject;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class FirebaseProjectDal implements IProjectDal {
    Firestore dbFirestore = FirestoreClient.getFirestore();


String agile_kanban_project= "agile_kanban_project";
    @Override
    @Transactional
    public List<MyProject> getAllProject() throws ExecutionException, InterruptedException {
        CollectionReference collectionReference = dbFirestore.collection(agile_kanban_project);

//        ApiFuture<DocumentSnapshot> future = documentReference.get();
        Iterable<DocumentReference> listDoc = collectionReference.listDocuments();

        List<MyProject> listMyUser = new ArrayList<>();
        for(DocumentReference d: listDoc){
            ApiFuture<DocumentSnapshot> future = d.get();
            DocumentSnapshot document = future.get();

            MyProject myProject;
            if(document.exists()){
                myProject = document.toObject(MyProject.class);
                listMyUser.add(myProject);
            }

//                listMyUser.add(d.get().get());
        }
        if(!listMyUser.isEmpty()){
            return listMyUser;
        }

        return null;
    }

    @Override
    @Transactional
    public String createMyProject(MyProject myProject) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(agile_kanban_project).document(myProject.getDocumentId()).set(myProject);

        return collectionsApiFuture.get().getUpdateTime().toString() +"\n"+"Successfully created "+ myProject.getDocumentId();

    }
}
