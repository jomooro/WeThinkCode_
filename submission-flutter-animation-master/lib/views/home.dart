import 'package:flutter/material.dart';
import 'package:funky_app/views/JumpingJackView.dart';
import 'package:funky_app/views/SpinningView.dart';

class FunkyHomeView extends StatefulWidget {
  const FunkyHomeView({super.key, required this.title});

  final String title;

  @override
  State<FunkyHomeView> createState() => _FunkyHomeViewState();
}

class _FunkyHomeViewState extends State<FunkyHomeView> {
  bool isZoomed = false;

  void _pushView(BuildContext context, Widget view) {
    Navigator.of(context).push(
      MaterialPageRoute(builder: (context) {
        return view;
      }),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            AnimatedContainer(
              duration: const Duration(seconds: 1),
              curve: Curves.easeInOut,
              width: isZoomed ? 200.0 : 100.0,
              height: isZoomed ? 200.0 : 100.0,
              child: Image.asset('assets/wethinkcode.png'),
            ),
            const SizedBox(height: 30),
            IconButton(
              onPressed: () {
                setState(() {
                  isZoomed = !isZoomed;
                });
              },
              icon: Icon(isZoomed ? Icons.zoom_out : Icons.zoom_in),
            ),
            const SizedBox(height: 15),
            ElevatedButton(
              onPressed: () {
                _pushView(context, const SpinningView(title: "Spin Spin Spin"));
              },
              child: const Text("Spinning View"),
            ),
            const SizedBox(height: 15), // Add space between buttons
            ElevatedButton(
              onPressed: () {
                _pushView(context, const JumpingJackView(title: "Jumping Jack"));
              },
              child: const Text("Jumping Jack View"),
            ),
          ],
        ),
      ),
    );
  }
}
