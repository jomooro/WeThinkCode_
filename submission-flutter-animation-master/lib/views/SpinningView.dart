import 'package:flutter/material.dart';

class SpinningView extends StatefulWidget {
  const SpinningView({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<SpinningView> createState() => _SpinningViewState();
}

class _SpinningViewState extends State<SpinningView>
    with SingleTickerProviderStateMixin {
  late AnimationController _controller;

  bool _isSpinning = false;

  @override
  void initState() {
    super.initState();

    _controller = AnimationController(
      vsync: this,
      duration: const Duration(seconds: 1),
    );
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  void _toggleSpin() {
    setState(() {
      if (_isSpinning) {
        _controller.stop();
      } else {
        _controller.repeat();
      }
      _isSpinning = !_isSpinning;
    });
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
          children: <Widget>[
            RotationTransition(
              turns: Tween(begin: 0.0, end: 1.0).animate(_controller),
              child: Image.asset('assets/wethinkcode.png'),
            ),
            const SizedBox(height: 60),
            ElevatedButton(
              onPressed: _toggleSpin,
              style: ElevatedButton.styleFrom(
              backgroundColor: Colors.orange,
              ),
              child: Text(_isSpinning ? 'Stop' : 'Spin'),
            ),
          ],
        ),
      ),
    );
  }
}
