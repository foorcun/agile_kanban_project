import 'package:flutter/material.dart';
import 'package:{{flutter_project_name.snakeCase()}}/features/{{feature_name.snakeCase()}}/presentation/state_management/binding/home_page_binding.dart';
import 'package:{{flutter_project_name.snakeCase()}}/main_presentation/home_page.dart';
import 'package:get/get.dart';

// flutter run -d chrome --web-hostname localhost --web-port 5000 --no-sound-null-safety
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: '{{flutter_project_name.sentenceCase()}}',
      initialRoute: "/homePage",
      getPages: [
        GetPage(
            name: "/homePage",
            page: () => const HomePage(),
            binding: HomePageBinding())
      ],
    );
  }
}
