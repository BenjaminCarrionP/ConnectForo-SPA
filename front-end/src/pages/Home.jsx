// src/pages/Home.jsx

import React, { useState } from 'react';
import Sidebar from '../components/Sidebar';
import SidebarDerecho from '../components/SidebarDerecho';
import ForoCard from '../components/ForoCard';
import Footer from '../components/Footer';

const Home = () => {
  // Tus 20 posts originales
  const publicacionesData = [
    { id: 1, titulo: "¡Bienvenidos al foro!", comentarios: 12, likes: 25 },
    { id: 2, titulo: "¿Cuál es tu anime favorito?", comentarios: 28, likes: 40 },
    { id: 3, titulo: "Sugerencias para el sitio", comentarios: 5, likes: 8 },
    { id: 4, titulo: "¿Qué serie estás viendo ahora?", comentarios: 15, likes: 32 },
    { id: 5, titulo: "Muestra tu setup gamer!", comentarios: 45, likes: 61 },
    { id: 6, titulo: "¿Mejor película del año?", comentarios: 10, likes: 19 },
    { id: 7, titulo: "Memes del día", comentarios: 30, likes: 42 },
    { id: 8, titulo: "Lugares que te gustaría visitar", comentarios: 18, likes: 34 },
    { id: 9, titulo: "Noticias tecnológicas", comentarios: 22, likes: 37 },
    { id: 10, titulo: "Comparte tu mascota", comentarios: 16, likes: 27 },
    { id: 11, titulo: "Recomendaciones de libros", comentarios: 14, likes: 20 },
    { id: 12, titulo: "Tips de estudio", comentarios: 11, likes: 17 },
    { id: 13, titulo: "Cultura pop", comentarios: 21, likes: 33 },
    { id: 14, titulo: "Tu top 5 de videojuegos", comentarios: 27, likes: 44 },
    { id: 15, titulo: "Apps útiles para estudiantes", comentarios: 13, likes: 22 },
    { id: 16, titulo: "¿Linux o Windows?", comentarios: 26, likes: 39 },
    { id: 17, titulo: "Comparte tu escritorio", comentarios: 10, likes: 18 },
    { id: 18, titulo: "Consejos de productividad", comentarios: 9, likes: 15 },
    { id: 19, titulo: "¿Qué música escuchas?", comentarios: 17, likes: 30 },
    { id: 20, titulo: "El futuro del AI", comentarios: 20, likes: 36 }
  ];

  // Lo convertimos al shape que usa ForoCard (todos en foro “General”)
  const publications = publicacionesData.map(p => ({
    id: p.id,
    foroId: 1,
    title: p.titulo,
    imageUrl: '/imgs/placeholder.jpg',
    content: '',
    upvotes: p.likes,
    downvotes: 0,
    comments: p.comentarios,
  }));

  const sorted = [...publications].sort((a, b) => b.upvotes - a.upvotes);

  return (
    <div className="min-h-screen bg-neutral-900 text-white">
      <div className="flex px-4 gap-6 mt-6">
        {/* Izquierda */}
        <Sidebar />

        {/* Centro */}
        <main className="flex-1 space-y-6">
          {sorted.map(pub => (
            <ForoCard
              key={pub.id}
              foro={{ id: 1, name: 'General', icon: '/icons/general.png' }}
              publication={pub}
            />
          ))}
        </main>

        {/* Derecha pegada */}
        <aside className="w-64 hidden lg:block">
          <div className="sticky top-24 flex flex-col gap-6">
            <SidebarDerecho />
            <Footer />
          </div>
        </aside>
      </div>
    </div>
  );
};

export default Home;
