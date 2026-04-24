import 'dart:math';
import 'package:flutter/material.dart';

class JumpingJackView extends StatefulWidget {
  const JumpingJackView({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<JumpingJackView> createState() => _JumpingViewState();
}

class _JumpingViewState extends State<JumpingJackView> with SingleTickerProviderStateMixin {
  late AnimationController _controller;
  late Animation<double> _jumpAnimation;

  final double jumpDistance = 400.0; // Adjust the jump distance as needed.

  @override
  void initState() {
    super.initState();
    _controller = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 1500),
    );

    final curvedAnimation = CurvedAnimation(parent: _controller, curve: Curves.easeInOut);

    _jumpAnimation = Tween<double>(
      begin: 0.0,
      end: 200.0,
    ).animate(curvedAnimation);
  }

  void jump() {
    if (!_controller.isAnimating) {
      _controller.forward(from: 0.0);
    }
  }

  @override
  Widget build(BuildContext context) {
    double screenWidth = MediaQuery.of(context).size.width;

    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            AnimatedBuilder(
              animation: _controller,
              builder: (context, child) {
                final jumpValue = _jumpAnimation.value;
                final jumpHeight = sin(jumpValue * pi) * 70.0;
                final jumpForward = _controller.value * jumpDistance;

                // If Jumping Jack reaches the end of the screen, loop back to the start
                if (jumpForward >= screenWidth) {
                  _controller.reset();
                }

                return Transform.translate(
                  offset: Offset(jumpForward, -jumpHeight),
                  child: child,
                );
              },
              child: const Icon(
                Icons.directions_run,
                size: 70,
              ),
            ),
            const SizedBox(height: 300),
            ElevatedButton(
              onPressed: jump,
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.orange,
              ),
              child: const Text("Jump"),
            ),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }
}
