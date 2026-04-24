import 'package:flutter/material.dart';
import 'details_view.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  late ThemeData currentTheme;
  bool isDarkMode = false;

  @override
  void initState() {
    super.initState();
    currentTheme = ThemeData.light();
  }

  @override
  Widget build(BuildContext context) {
    return Theme(
      data: currentTheme,
      child: Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              ElevatedButton(
                onPressed: _showViewPressed,
                style: ElevatedButton.styleFrom(
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(20),
                  ),
                ),
                child: Text(
                  "Show View",
                  style: Theme.of(context).textTheme.headline5,
                ),
              ),
              const SizedBox(height: 32.0),
              Text(
                'View Theme',
                style: Theme.of(context).textTheme.headline6,
              ),
              const SizedBox(height: 16.0),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Switch(
                    value: isDarkMode,
                    onChanged: (value) {
                      setState(() {
                        isDarkMode = value;
                        currentTheme = value ? ThemeData.dark() : ThemeData.light();
                      });
                    },
                  ),
                ],
              ),
              RadioListTile<ThemeData>(
                title: const Text("Professional Theme"),
                value: ThemeData(
                  primarySwatch: Colors.blue,
                ),
                groupValue: currentTheme,
                onChanged: (themeData) => _updateCurrentTheme(themeData!),
              ),
              RadioListTile<ThemeData>(
                title: const Text("Calm Theme"),
                value: ThemeData(
                  primarySwatch: Colors.green,
                ),
                groupValue: currentTheme,
                onChanged: (themeData) => _updateCurrentTheme(themeData!),
              ),
              RadioListTile<ThemeData>(
                title: const Text("Gamer Theme"),
                value: ThemeData(
                  primarySwatch: Colors.red,
                ),
                groupValue: currentTheme,
                onChanged: (themeData) => _updateCurrentTheme(themeData!),
              ),
              const SizedBox(height: 32.0),
            ],
          ),
        ),
      ),
    );
  }

  void _updateCurrentTheme(ThemeData themeData) {
    setState(() {
      currentTheme = themeData;
    });
  }

  void _showViewPressed() {
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (context) => DetailsView(
          key: UniqueKey(),
          currentTheme: currentTheme,
        ),
      ),
    );
  }
}